package com.edutilos.simpleproject


interface  ProgrammerDAO {
  public void save(Programmer pro)
    public void update(long id, Programmer newPro)
   public void delete(long id)
    public Programmer findById(long id)
    public List<Programmer> findAll()
    public void deleteAll()
}
