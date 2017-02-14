package com.edutilos.simpleproject



class ProgrammerDAOInMemoryImpl implements  ProgrammerDAO{
    Map<Long, Programmer> map = new HashMap<Long, ProgrammerDAO> ()

    @Override
    void save(Programmer pro) {
       map[pro.id] = pro
    }

    @Override
    void update(long id, Programmer newPro) {
        map[newPro.id] = newPro
    }

    @Override
    void delete(long id) {
        map.remove(id)
    }

    @Override
    Programmer findById(long id) {
        return map[id]
    }

    @Override
    List<Programmer> findAll() {
         List<Programmer> list = new ArrayList<>()
        map.each{entry ->
           list.add(entry.value)
        }
        return list
    }

    @Override
    void deleteAll() {
        map.clear()
    }
}
