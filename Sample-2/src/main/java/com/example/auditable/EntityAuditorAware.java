package com.example.auditable;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class EntityAuditorAware implements AuditorAware<String> {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Optional getCurrentAuditor() {
		return Optional.of("Harini");

	}
}
