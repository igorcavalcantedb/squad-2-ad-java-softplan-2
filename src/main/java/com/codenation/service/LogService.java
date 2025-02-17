package com.codenation.service;

import com.codenation.entity.Log;
import com.codenation.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class LogService {

  @Autowired
  private LogRepository logRepository;

  public Page<Log> findAll(Pageable pageable) {
    Page<Log> result = logRepository.findAllByStored(false, pageable);

    for(Log log: result.getContent()){
      log.setEvents(Collections.frequency(result.getContent(), log));
    }
    return result;
  }

  public Optional<Log> findById(Long id) {
    return logRepository.findById(id);
  }

  public Optional<Log> findByIdAndEnvironment(Long id, String environment) {
    return logRepository.findByStoredAndIdAndEnvironment(false, id, environment);
  }

  public void deleteById(Long aLong) {
    logRepository.deleteById(aLong);
  }

  public Page<Log> findByOrigin(String origin, Pageable pageable) {
    Page<Log> result = logRepository.findByStoredAndOriginContainingIgnoreCase(false, origin, pageable);

    for(Log log: result.getContent()){
      log.setEvents(Collections.frequency(result.getContent(), log));
    }
    return result;
  }

  public Page<Log> findByDetail(String detail, Pageable pageable) {
    Page<Log> result = logRepository.findByStoredAndDetailContainingIgnoreCase(false, detail, pageable);

    for(Log log: result.getContent()){
      log.setEvents(Collections.frequency(result.getContent(), log));
    }
    return result;
  }

  public Page<Log> findByLevel(String level, Pageable pageable) {
    Page<Log> result = logRepository.findByStoredAndLevelContainingIgnoreCase(false,  level, pageable);

    for(Log log: result.getContent()){
      log.setEvents(Collections.frequency(result.getContent(), log));
    }

    return result;
  }

  public void save(List<Log> objects) {
    for(Log log: objects){
      logRepository.save(log);
    }
  }
  
  public Page<Log> findByEnvironment(String environment, Pageable pageable) {
		return logRepository.findByStoredAndEnvironmentIgnoreCase(false, environment, pageable);
	}
  
	public Page<Log> findByEnvironmentAndLevel(String environment, String level, Pageable pageable) {
		return logRepository.findByStoredAndEnvironmentAndLevelIgnoreCase(false, environment, level, pageable);
	}

  public Page<Log> findByOriginOrLevel(String origin, String level, String environment, Pageable pageable) {
    return logRepository.findByStoredAndEnvironmentAndOriginOrLevelIgnoreCase(false, origin, level, environment, pageable);
  }

  
}
