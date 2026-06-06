package com.yo.day1.service;

import com.yo.day1.common.exception.NotFoundException;
import com.yo.day1.dto.parent.ParentDashboardResponse;
import org.apache.coyote.BadRequestException;

public interface ParentPortalService {
    ParentDashboardResponse getDashboard(String username) throws BadRequestException, NotFoundException;
}
