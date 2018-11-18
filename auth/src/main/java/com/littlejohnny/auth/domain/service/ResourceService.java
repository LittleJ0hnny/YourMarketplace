package com.littlejohnny.auth.domain.service;

import com.littlejohnny.auth.domain.model.entity.Resource;
import com.littlejohnny.auth.domain.repository.ResourceRepository;

public interface ResourceService extends Service<Resource, Long, ResourceRepository> {
}
