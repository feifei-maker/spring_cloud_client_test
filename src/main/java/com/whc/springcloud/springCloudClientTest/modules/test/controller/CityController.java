package com.whc.springcloud.springCloudClientTest.modules.test.controller;
import com.github.pagehelper.PageInfo;
import com.whc.springcloud.springCloudClientTest.modules.common.vo.Result;
import com.whc.springcloud.springCloudClientTest.modules.common.vo.SearchVo;
import com.whc.springcloud.springCloudClientTest.modules.test.entity.City;
import com.whc.springcloud.springCloudClientTest.modules.test.service.CityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * ClassName: CityController <br/>
 * Description: <br/>
 * date: 2020/8/31 14:00<br/>
 *
 * @author FEI FEI<br/>
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 127.0.0.1/api/cities/522 ---- get
     */
    @GetMapping("/cities/{countryId}")
    public List<City> getCitiesByCountryId(@PathVariable  int countryId) {
        return cityService.getCitiesByCountryId(countryId);
    }

    /**
     * 127.0.0.1/api/cities/522 --- post
     * {"currentPage":"1","pageSize":"5"}
     */
    @PostMapping(value = "/cities/{countryId}", consumes = "application/json")
    public PageInfo<City> getCitiesBySearchVo(
            @PathVariable int countryId, @RequestBody SearchVo searchVo) {
        return cityService.getCitiesBySearchVo(countryId, searchVo);
    }

    /**
     * 127.0.0.1/api/cities --- post
     * {"currentPage":"1","pageSize":"5","keyWord":"Sh","orderBy":"city_name","sort":"desc"}
     */
    @PostMapping(value = "/cities", consumes = "application/json")
    public PageInfo<City> getCitiesBySearchVo(@RequestBody SearchVo searchVo) {
        return cityService.getCitiesBySearchVo(searchVo);
    }

    /**
     * 127.0.0.1/api/city ---- post
     * {"cityName":"test1","localCityName":"freeCity","countryId":"522"}
     */
    @PostMapping(value = "/city", consumes = "application/json")
    public Result<City> insertCity(@RequestBody City city) {
        return cityService.insertCity(city);
    }

    /**
     * 127.0.0.1/api/city ---- put
     * "cityId"="2259",cityName"="aaaaa"
     */
    @PutMapping(value = "/city", consumes = "application/x-www-form-urlencoded")
    public Result<City> updateCity(@ModelAttribute City city) {
        return cityService.updateCity(city);
    }

    /**
     * 127.0.0.1/api/city/2258 ---- delete
     */
    @DeleteMapping("/city/{cityId}")
    public Result<Object> deleteCity(@PathVariable int cityId) {
        return cityService.deleteCity(cityId);
    }

}
