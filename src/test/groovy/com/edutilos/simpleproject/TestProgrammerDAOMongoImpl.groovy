package com.edutilos.simpleproject



class TestProgrammerDAOMongoImpl extends GroovyTestCase{
 private ProgrammerDAO dao = new ProgrammerDAOMongoImpl()


    private void insert() {
        Programmer p1 , p2
        p1 = new Programmer(1, "foo", 10 , 100.0 , true)
        p2 = new Programmer(2, "bar", 20, 200.0 , false)
        dao.save(p1)
        dao.save(p2)
    }

    private void clean() {
        dao.deleteAll()
    }


    public void testSave() {
        insert()
        List<Programmer> list = dao.findAll()
        assert 2 == list.size()
        assert "foo" == list[0].name
        assert "bar" == list[1].name
      clean()
    }

    public void testFindAll() {
         insert()
         List<Programmer> list = dao.findAll()
        assert 2 == list.size()
        def p1 = list[0]
        assert "foo" == p1.name
        assert 1 == p1.id
        assert 10 == p1.age
        assert true == p1.patient
        clean()
    }


    public void testUpdate() {
        insert()
        dao.update(1, new Programmer(1 , "newfoo", 66, 666.6 , false))
        Programmer p = dao.findById(1)
        assert 1 == p.id
        assert "newfoo" == p.name
        assert 66 == p.age
        assert 666.6 == p.wage
        assert false == p.patient
        clean()
    }


    public void testFindById() {
        insert()
        Programmer p = dao.findById(2)
        assert 2 == p.id
        assert "bar" == p.name
        assert 20 == p.age
        assert 200.0 == p.wage
        assert false == p.patient
        clean()
    }
    public void testDelete() {
       insert()
        dao.delete(1)
        List<Programmer> list= dao.findAll()
        assert 1 == list.size()
        clean()
    }
}



