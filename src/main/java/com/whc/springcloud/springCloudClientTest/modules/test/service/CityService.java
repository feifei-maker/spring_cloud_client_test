package com.whc.springcloud.springCloudClientTest.modules.test.service;

import com.github.pagehelper.PageInfo;
import com.whc.springcloud.springCloudClientTest.modules.common.vo.Result;
import com.whc.springcloud.springCloudClientTest.modules.common.vo.SearchVo;
import com.whc.springcloud.springCloudClientTest.modules.test.entity.City;

import java.util.List;

/**
 * ClassName: CityService <br/>
 * Description: <br/>
 * date: 2020/8/31 14:04<br/>
 *
 * @author FEI FEI<br/>
 * @since JDK 1.8
 */
public interface CityService {

    List<City> getCitiesByCountryId(int countryId);

    PageInfo<City> getCitiesBySearchVo(int countryId, SearchVo searchVo);

    PageInfo<City> getCitiesBySearchVo(SearchVo searchVo);

    Result<City> insertCity(City city);

    Result<City> updateCity(City city);

    Result<Object> deleteCity(int cityId);
}
