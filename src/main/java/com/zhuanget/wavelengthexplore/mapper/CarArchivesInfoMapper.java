package com.zhuanget.wavelengthexplore.mapper;

import com.zhuanget.wavelengthexplore.dto.CarArchivesInfoDto;
import com.zhuanget.wavelengthexplore.dto.CarArchivesReq;
import com.zhuanget.wavelengthexplore.entity.CarArchivesInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆档案 Mapper 接口
 * </p>
 *
 * @author Zhuang_ET
 * @since 2021-02-02
 */
@Mapper
public interface CarArchivesInfoMapper extends BaseMapper<CarArchivesInfo> {
    List<Map> divStatistic(String exacSql);

    Long queryCarArchiveCountByTime(@Param("startDate") String startTime, @Param("endDate") String endDate);

    int countByLocation(@Param("location") List<String> location);

    Date getMaxTime();

    List<String> queryPlateNumber();

    List<CarArchivesInfoDto> selectCarArchivesList(CarArchivesReq carArchivesReq);

    List<Long> countCarActiveNum(CarArchivesReq carArchivesReq);

    List<Long> countCarNewAddtionalNum(CarArchivesReq carArchivesReq);

    List<Long> countCarTotalNum(CarArchivesReq carArchivesReq);

    Long getCarId(@Param("plateNumber") String plateNumber);

    List<Long> countCarNewAddtionalNumByTime(@Param("endTime") String endTime, @Param("startTime") String startTime, @Param("req") CarArchivesReq carArchivesReq);

    List<Long> countEventNewAddNum(@Param("unActiveTime") Date unActiveTime,@Param("req") CarArchivesReq carArchivesReq);

    Long countCarTotalNumSize(CarArchivesReq carArchivesReq);

    Long countEventNewAddNumSize(@Param("unActiveTime") Date unActiveTime,@Param("req") CarArchivesReq carArchivesReq);

    Long countCarActiveNumSize(CarArchivesReq carArchivesReq);

    Long countCarNewAddtionalNumSize(CarArchivesReq carArchivesReq);

    List<Long> queryIdsByIdsAndPlateNumbers(@Param("newAddIds") List<Long> newAddIds,@Param("plateNumbers") List<String> plateNumbers);
}
