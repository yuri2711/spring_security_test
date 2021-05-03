package ru.yuri.DAO;

import ru.yuri.model.People;

import java.util.List;

public interface PeopleDAO {
    List<People> index();
    People get(int id);
    void save(People people);
    void update(People people);
    void delete(int id);

    People getUserByName(String username);
}
