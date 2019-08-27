/* 
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2018-12-08 21:04 创建
 */
package org.antframework.configcenter.biz.provider;

import lombok.AllArgsConstructor;
import org.antframework.boot.bekit.CommonQueries;
import org.antframework.common.util.facade.EmptyResult;
import org.antframework.configcenter.biz.util.QueryUtils;
import org.antframework.configcenter.dal.dao.ReleaseDao;
import org.antframework.configcenter.facade.api.ReleaseService;
import org.antframework.configcenter.facade.order.*;
import org.antframework.configcenter.facade.result.*;
import org.bekit.service.ServiceEngine;
import org.springframework.stereotype.Service;

/**
 * 发布服务提供者
 */
@Service
@AllArgsConstructor
public class ReleaseServiceProvider implements ReleaseService {
    // 服务引擎
    private final ServiceEngine serviceEngine;

    @Override
    public AddReleaseResult addRelease(AddReleaseOrder order) {
        return serviceEngine.execute("addReleaseService", order);
    }

    @Override
    public DeleteReleaseResult deleteRelease(DeleteReleaseOrder order) {
        return serviceEngine.execute("deleteReleaseService", order);
    }

    @Override
    public EmptyResult revertRelease(RevertReleaseOrder order) {
        return serviceEngine.execute("revertReleaseService", order);
    }

    @Override
    public FindCurrentReleaseResult findCurrentRelease(FindCurrentReleaseOrder order) {
        return serviceEngine.execute("findCurrentReleaseService", order);
    }

    @Override
    public FindReleaseResult findRelease(FindReleaseOrder order) {
        return serviceEngine.execute("findReleaseService", order);
    }

    @Override
    public QueryReleasesResult queryReleases(QueryReleasesOrder order) {
        CommonQueries.CommonQueryResult result = serviceEngine.execute(CommonQueries.SERVICE_NAME, order, QueryUtils.buildCommonQueryAttachment(ReleaseDao.class));
        return result.convertTo(QueryReleasesResult.class);
    }
}
