package com.mbg.dao;

import com.mbg.po.Department;

public interface DepartmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbg.generated Wed May 08 13:09:51 CST 2019
     */
    int deleteByPrimaryKey(Integer dept_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbg.generated Wed May 08 13:09:51 CST 2019
     */
    int insert(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbg.generated Wed May 08 13:09:51 CST 2019
     */
    int insertSelective(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbg.generated Wed May 08 13:09:51 CST 2019
     */
    Department selectByPrimaryKey(Integer dept_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbg.generated Wed May 08 13:09:51 CST 2019
     */
    int updateByPrimaryKeySelective(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbg.generated Wed May 08 13:09:51 CST 2019
     */
    int updateByPrimaryKey(Department record);
}