package com.deadcrow.girl.service;

import com.deadcrow.girl.domain.Girl;
import com.deadcrow.girl.enums.ResultEnum;
import com.deadcrow.girl.exception.GirlException;
import com.deadcrow.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA= new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);


        Girl girlB= new Girl();
        girlB.setAge(19);
        girlB.setCupSize("B");
        girlRepository.save(girlB);

    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();

        if(age < 10){
            //返回"幼女"
            throw new GirlException(ResultEnum.YOUNV);
        }
        else if(age < 16 && age >10){
            //返回萝莉
            throw new GirlException(ResultEnum.LORY);
        }
        else {
            //返回御姐
            throw new GirlException(ResultEnum.YUJIE);
        }
    }

    /**
     * 通过ID查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
