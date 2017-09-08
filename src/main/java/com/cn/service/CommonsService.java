package com.cn.service;

import com.cn.exception.DBException;
import com.cn.mapper.CommonMapper;
import com.cn.model.entity.CustomerScanningCopy;
import com.cn.model.entity.FileUpload;
import com.cn.model.entity.FileUploadSigning;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * CommonsService
 *
 * @author guowy
 * @create 2017-06-22 10:15
 **/

public abstract class CommonsService<T,Q,PK extends Serializable> {

    public abstract CommonMapper<T, Q, PK> getMapper();

    public  int insert(T body) {
        return insert(body,true);
    }

    public int insert(T body,boolean isSelective){
        if(isSelective){
            return getMapper().insertSelective(body);
        }else{
            return getMapper().insert(body);
        }
    }

    public List<T> getAll() {
        return getMapper().getAll();
    }

    //校验文件是否已经上传
    public FileUpload fileUploadQuery(Q md5) {
        return getMapper().selectBYExample(md5);
    }


    public FileUploadSigning selectByPrimaryKey(Long id){
        return  getMapper().selectFileUploadSigningByPrimaryKey(id);
    }

    public FileUploadSigning selectByPrimaryByOrderId(String orderId) {
        return getMapper().selectByPrimaryByOrderId(orderId);
    }

    public FileUploadSigning uploadFileByOrderNum(String orderId, FileUploadSigning fileUploadSigning) {
       return getMapper().uploadFileByOrderNum(orderId,fileUploadSigning);
    }

    public  List<CustomerScanningCopy> selectByOrderNumAndMd5(String orderNum, String md5) {
        return getMapper().selectByOrderNumAndMd5(orderNum, md5);
    }

    public  void uploadCustomerScanningCopy(String orderNum, String md5Hex, String fileSuffix) {
        System.out.println("链接服务器");
    }

    public <S> S preview(String orderNum, String md5Hex, String fileSuffix) {
        System.out.println("链接服务器");
        return null;
    }

    public <S> List<CustomerScanningCopy> findFileByOrderNum(String orderNum) {
        return getMapper().findFileByOrderNum(orderNum);
    }

    public <S> String getPreviewUrl(String md5,String type) {
        return null;
    }

    public <S> S getPreviewThumbnailsUrl(String md5,String type) {
        return null;
    }


//    ------------------------------------------------------------------------------------

    @Transactional(readOnly = true)
    public List<T> findBy(Q query){
        return getMapper().selectByExample(query);
    }

    public T findByOne(Q query){
        List<T> list = findBy(query);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    public List<T> findAll(){
        return getMapper().selectByExample(null);
    }

    @Transactional(readOnly = true)
    public int countByExample(Q query){
        return getMapper().countByExample(query);
    }

    @Transactional(readOnly = true)
    public List<T> findBy(RowBounds rowBounds, Q query){
        return getMapper().selectByExample(rowBounds,query);
    }
    //    selectByExampleWithBLOBs
    @Transactional(readOnly = true)
    public List<T> findByWithBLOBs(RowBounds rowBounds, Q query){
        return getMapper().selectByExampleWithBLOBs(rowBounds,query);
    }


    @Transactional(readOnly = true)
    public T findByID(final PK id){
        return (T) getMapper().selectByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    public  T selectOneByExample(Q query)  {
        List<T> list = (List<T>) findBy(query);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }else if(list.size()>1){
            throw new DBException("获取多个结果集");
        }
        return (T) list.get(0);
    }


    public int save(T record){
        return save(record,true);
    }


    public int save(T record,boolean isSelective){
        if(isSelective){
            return getMapper().insertSelective(record);
        }else{
            return getMapper().insert(record);
        }

    }

    public int batchSave(List<T> tsr){
        for(T t : tsr){
            getMapper().insert(t);
        }
        return tsr.size();
//       return getMapper().insertBatch(tsr);
    }

    public int updateByKey(T record){
//        Assert.notNull(record);
        return updateByKey(record,true);
    }

    public int updateByKey(T record,boolean isSelective){
        if(isSelective){
            return getMapper().updateByPrimaryKeySelective(record);
        }else{
            return getMapper().updateByPrimaryKey(record);
        }
    }

    public int updateByQuery(T record,Q query){
        return updateByQuery(record,query,true);
    }

    public int updateByQuery(T record,Q query,boolean isSelective){
        if(isSelective){
            return getMapper().updateByExampleSelective(record, query);
        }else{
            return getMapper().updateByExample(record, query);
        }
    }

    public int delete(Q query){
        return getMapper().deleteByExample(query);
    }

    public int deleteByID(final PK id){
        return getMapper().deleteByPrimaryKey(id);
    }

    public List<Map<String,String>> selectBySQL(String sql){
        return getMapper().selectBySQL(sql);
    }

    public List<Map<String,Object>> findBySQL(String sql){
        return getMapper().findBySQL(sql);
    }

    public int updateBySQL(String sql){
        return getMapper().updateBySQL(sql);
    }

    public int countBySQL(String sql){
        return getMapper().countBySQL(sql);
    }

    public int deleteBySQL(String sql){
        return getMapper().deleteBySQL(sql);
    }

    public int insertBySQL(String sql){
        return getMapper().insertBySQL(sql);
    }


}