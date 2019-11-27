package com.dao;

/**
 * @author cj
 * @date 2019/10/30
 */
public class DeptDaoImpl extends BaseDao {


    /**
     * 如果这个方法抛了异常,但是你自己在内部捕获处理掉了等价于没有抛出异常
     *
     *
     *
     * @param id
     * @throws Exception
     */
    public void deleteById(int id) throws Exception {

        String sql = "delete from dept where id =?";
        int i = 5/0;
        //throwEx();
        jdbcTemplate.update(sql, id);

    }

    private void throwEx() throws  Exception{
        throw new MyCheckEx();

    }
}
