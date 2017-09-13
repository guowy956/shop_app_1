package com.cn.mapper;

import com.cn.model.domain.AddressLibrary;
import com.cn.model.domain.AddressLibraryExample;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface AddressLibraryMapper<T,Q,PK extends Serializable> extends CommonMapper<T,Q,PK> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_library
     *
     * @mbggenerated Fri Sep 08 10:18:39 CST 2017
     */
    int countByExample(AddressLibraryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_library
     *
     * @mbggenerated Fri Sep 08 10:18:39 CST 2017
     */
    int deleteByExample(AddressLibraryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_library
     *
     * @mbggenerated Fri Sep 08 10:18:39 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_library
     *
     * @mbggenerated Fri Sep 08 10:18:39 CST 2017
     */
    int insert(AddressLibrary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_library
     *
     * @mbggenerated Fri Sep 08 10:18:39 CST 2017
     */
    int insertSelective(AddressLibrary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_library
     *
     * @mbggenerated Fri Sep 08 10:18:39 CST 2017
     */
    List<AddressLibrary> selectByExample(AddressLibraryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_library
     *
     * @mbggenerated Fri Sep 08 10:18:39 CST 2017
     */
    AddressLibrary selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_library
     *
     * @mbggenerated Fri Sep 08 10:18:39 CST 2017
     */
    int updateByExampleSelective(@Param("record") AddressLibrary record, @Param("example") AddressLibraryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_library
     *
     * @mbggenerated Fri Sep 08 10:18:39 CST 2017
     */
    int updateByExample(@Param("record") AddressLibrary record, @Param("example") AddressLibraryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_library
     *
     * @mbggenerated Fri Sep 08 10:18:39 CST 2017
     */
    int updateByPrimaryKeySelective(AddressLibrary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_library
     *
     * @mbggenerated Fri Sep 08 10:18:39 CST 2017
     */
    int updateByPrimaryKey(AddressLibrary record);
}