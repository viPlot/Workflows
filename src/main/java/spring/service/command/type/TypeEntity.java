package spring.service.command.type;

import lombok.RequiredArgsConstructor;

import java.util.TreeMap;

@RequiredArgsConstructor
public class TypeEntity implements CommandType{
    private final TreeMap<Integer, String> map;

    @Override
    public String findById(long id) {
        return map.get(id);
    }

    @Override
    public TreeMap findAll() {
        return map;
    }
}
