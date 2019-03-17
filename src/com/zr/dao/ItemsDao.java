package com.zr.dao;

import com.zr.entity.Items;
import com.zr.util.DataUtil;
import com.zr.util.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ItemsDao {

    private QueryRunner queryRunner =  new QueryRunner(DataUtil.getDataSource());
    public PageBean<Items> queryPageBean(int pageIndex,int pageCount){
        PageBean<Items> pageBean =  new PageBean<>();
        pageBean.setCount(getCount());
        pageBean.setPageIndex(pageIndex);
        pageBean.setPageCount(pageCount);
        int index = pageBean.getIndex();
        String sql = "select * from items limit ?,?";
        List<Items> itemsList = null;
        try {
            itemsList = queryRunner.query(sql, new BeanListHandler<>(Items.class), index, pageCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pageBean.setList(itemsList);
        return pageBean;
    }

    public int getCount(){
        int count = 0;
        String sql ="select count(*)  count from items ";
        try {
            Number query = queryRunner.query(sql, new ScalarHandler<>());
            count = query.intValue();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}
