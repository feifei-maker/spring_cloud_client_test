package com.whc.springcloud.springCloudClientTest.modules.test.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whc.springcloud.springCloudClientTest.modules.common.vo.Result;
import com.whc.springcloud.springCloudClientTest.modules.common.vo.SearchVo;
import com.whc.springcloud.springCloudClientTest.modules.test.dao.CityDao;
import com.whc.springcloud.springCloudClientTest.modules.test.entity.City;
import com.whc.springcloud.springCloudClientTest.modules.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
/**
 * ClassName: CityServiceImpl <br/>
 * Description: <br/>
 * date: 2020/8/31 14:05<br/>
 *
 * @author FEI FEI<br/>
 * @since JDK 1.8
 */
@Service
public class CityServiceImpl implements CityService {

    @Value("${server.port}")
    private int port;
    @Autowired
    private CityDao cityDao;

    @Override
    public List<City> getCitiesByCountryId(int countryId) {
        System.out.println("Server Port:" + port);
//        return cityDao.getCitiesByCountryId(countryId);
        return Optional
                .ofNullable(cityDao.getCitiesByCountryId(countryId))
                .orElse(Collections.emptyList());
    }

    @Override
    public PageInfo<City> getCitiesBySearchVo(int countryId, SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<City>(
                Optional.ofNullable(cityDao.getCitiesByCountryId(countryId))
                        .orElse(Collections.emptyList()));
    }

    @Override
    public PageInfo<City> getCitiesBySearchVo(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<>(
                Optional.ofNullable(cityDao.getCitiesBySearchVo(searchVo))
                        .orElse(Collections.emptyList()));
    }

    @Override
    @Transactional
    public Result<City> insertCity(City city) {
        city.setDateCreated(new Date());
        cityDao.insertCity(city);
        return new Result<City>(Result.ResultStatus.SUCCESS.status,
                "Insert success.", city);
    }

    @Override
    @Transactional(noRollbackFor = ArithmeticException.class)
    public Result<City> updateCity(City city) {
        cityDao.updateCity(city);
//        int i = 1 / 0;
        return new Result<>(Result.ResultStatus.SUCCESS.status,
                "Update success", city);
    }

    @Override
    @Transactional
    public Result<Object> deleteCity(int cityId) {
        cityDao.deleteCity(cityId);
        return new Result<Object>(Result.ResultStatus.SUCCESS.status,
                "Delete success.");
    }
}
