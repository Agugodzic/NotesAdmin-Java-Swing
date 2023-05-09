package Interface;

import java.util.List;

public interface UserInterface<T,V>{

    public boolean createUser(T model);

    public T findUser(V idModel);

    public T updateUser(T model, V id);

    public boolean deleteUser(V id);

    public List<T> findAll();
}
