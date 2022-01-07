package BootAndShell.repository;

import BootAndShell.service.dao.domain.Branch;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class JdbcBranchRepository implements BranchRepository {
    private final static RowMapper<Branch> MAPPER = (rs, num) ->
            new Branch(rs.getLong("id"), rs.getString("city"),
            rs.getInt("index"), rs.getInt("number"),
                    rs.getString("address"));

    private final static ResultSetExtractor<List<Branch>> EXTRACTOR = rs ->{
        var branch = new ArrayList<Branch>();
        var currentBranch = new Branch(0, null, 0, 0, null);
        while (rs.next()) {
            var branchId = rs.getLong("b_id");
            if (currentBranch.getId() != branchId) {
                currentBranch = new Branch(branchId, rs.getString("b_city"),
                        rs.getInt("b_index"), rs.getInt("b_number"),
                        rs.getString("b_address"));
                branch.add(currentBranch);
            }
        }
        return branch;
    };

    private final NamedParameterJdbcOperations jdbc;

    @Override
    public Collection<Branch> findAll() {
        return jdbc.query("""
                select
                b.id b_id,
                b.city b_sity,
                b.index b_index,
                b.number b_number,
                b.address b_address
                from branch b
                order by b.id
                """, EXTRACTOR);
    }

    @Override
    public Collection<Branch> findByCity(String city) {
        return jdbc.query("""
                select
                b.id b_id,
                b.city b_sity,
                b.index b_index,
                b.number b_number,
                b.address b_address
                from branch b
                where lower(city) like :city
                order by b.id
                """,
                Map.of("titlePart", "%" + city.strip().toLowerCase() + "%"),
                EXTRACTOR);
    }

    @Override
    public Optional<Branch> findById(long id) {
        var list =  jdbc.query("""
                select
                b.id b_id,
                b.city b_sity,
                b.index b_index,
                b.number b_number,
                b.address b_address
                from branch b
                where b_id = :id
                """,
                Map.of("id", id),
                EXTRACTOR);
        if (list.isEmpty())
            return Optional.empty();
        else
            return Optional.of(list.get(0));
    }

    @Override
    public void insert(Branch branch) {
        var keyHolder = new GeneratedKeyHolder();
        var params = new MapSqlParameterSource();
        params.addValue("city", branch.getCity());
        params.addValue("index", branch.getIndex());
        params.addValue("number", branch.getNumber());
        params.addValue("address", branch.getAddress());
        jdbc.update("""
                insert into branch (sity, index, number, address)
                values (:city, :index, :number, :address)
                """,
                params,
                keyHolder);
        branch.setId((Long)(keyHolder.getKeys().get("id")));
    }

    @Override
    public void update(Branch branch) {
        var params = new MapSqlParameterSource();
        params.addValue("city", branch.getCity());
        params.addValue("index", branch.getIndex());
        params.addValue("number", branch.getNumber());
        params.addValue("address", branch.getAddress());
        jdbc.update("""
                update branch set sity = :city, index = :index, number = :number, address = :address
                where id = :id
                """,
                params);
    }

    @Override
    public void delete(Branch branch) {
    jdbc.update("""
            delete from branch
            where id = :id
            """,
            Map.of("id", branch.getId()));
    }
}