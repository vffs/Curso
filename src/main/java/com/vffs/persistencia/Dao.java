
package com.vffs.persistencia;

import java.util.List;

/**
 *
 * @author valeria
 */
public interface Dao<T> {
    
    public void createTable();
    public void insert(final T t);
    public T findById(final Long id);
    public List<T> findAll();
    public void update(final Long id, final T t);
    public void delete(final Long id);
    
}
