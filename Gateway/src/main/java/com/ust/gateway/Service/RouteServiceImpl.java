package com.ust.gateway.Service;

import org.springframework.stereotype.Service;

import com.ust.gateway.Model.ApiRoutes;
import com.ust.gateway.Repository.RouteRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RouteServiceImpl implements RouteService{ 
	private RouteRepository routeRepository; 
	
	 public RouteServiceImpl(RouteRepository routeRepository) {
	        this.routeRepository = routeRepository;
	    }

	    @Override
	    public Flux<ApiRoutes> getAll() {
	        return this.routeRepository.findAll();
	    }

	    @Override
	    public Mono<ApiRoutes> create(ApiRoutes apiRoute) {
	        Mono<ApiRoutes> route = this.routeRepository.save(apiRoute);
	        return route;
	    }

	    @Override
	    public Mono<ApiRoutes> getById(String id) {
	        return this.routeRepository.findById(id);
	    }
}