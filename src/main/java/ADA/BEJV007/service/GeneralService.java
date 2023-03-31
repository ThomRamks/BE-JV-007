package ADA.BEJV007.service;

import java.util.List;

public interface GeneralService<T> {
    List<T> list();
    T save(T t);
    T saveHtml(T t);
    T findById(Long id);
    T update (Long id, T t);
    void delete (Long id);
}
