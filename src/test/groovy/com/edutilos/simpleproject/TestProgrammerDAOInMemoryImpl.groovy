package com.edutilos.simpleproject


class TestProgrammerDAOInMemoryImpl extends GroovyTestCase {

    private ProgrammerDAO dao = new ProgrammerDAOInMemoryImpl()

    private void insert() {
        Programmer p1  ,p2
        p1 = new Programmer(1 , "foo", 10, 100.0 , true)
        p2 = new Programmer(2, "bar", 30 , 300.0 , false)
        dao.save(p1)
        dao.save(p2)
    }

    private void clean() {
        dao.deleteAll()
    }



    public void testSave() {
        insert()
        List<Programmer> all = dao.findAll()
        assertEquals(2 , all.size())
        clean()
    }



    public void testUpdate() {
        insert()
        Programmer newP = new Programmer(1, "newfoo", 20 , 200.0 , false)
        dao.update(1, newP)

        Programmer p = dao.findById(1)
        assertEquals("newfoo", p.name)
        assertEquals(1L , p.id)
        assertEquals(20 , p.age)
        assertEquals(200.0 , p.wage)
        assertEquals(false, p.patient)

       clean()
    }



    public void testFindAll() {
       insert()
        List<Programmer> all = dao.findAll()
        assertEquals(2, all.size())
        assertEquals("foo", all.get(0).name)
        assertEquals("bar", all.get(1).name)
       clean()
     }


   public void testFindById() {
       insert()
       long id = 2
       Programmer p = dao.findById(id)
       assertEquals(2, p.id)
       assertEquals("bar", p.name)
       assertEquals(30,p.age)
       assertEquals(300.0, p.wage)
       assertEquals(false, p.patient)
     clean()
   }


  public void testDelete() {
      insert()
     dao.delete(1)
      List<Programmer> all = dao.findAll()
      assertEquals(1, all.size())
    clean()
  }


}
