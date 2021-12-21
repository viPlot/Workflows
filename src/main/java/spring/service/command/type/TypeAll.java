package spring.service.command.type;

import lombok.RequiredArgsConstructor;

import java.util.TreeMap;

@RequiredArgsConstructor
public class TypeAll implements CommandType {
    private final TreeMap<Integer, String> map;

    @Override
    public TreeMap findAll() {
        return map;
    }

    @Override
    public String findById(long id) {
        return null;
    }
}
