package com.yo.day1.service.impl;

import com.yo.day1.common.exception.BadRequestException;
import com.yo.day1.common.exception.NotFoundException;
import com.yo.day1.domain.entity.Parents;
import com.yo.day1.domain.entity.User;
import com.yo.day1.repository.ParentResponsitory;
import com.yo.day1.repository.UserRepository;
import com.yo.day1.service.ParentService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService {
    private final ParentResponsitory parentRespository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public ParentServiceImpl(ParentResponsitory parentRespository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.parentRespository = parentRespository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public List<Parents> findAll() { return parentRespository.findAll(); }

    public Optional<Parents> findById(Long id) { return parentRespository.findById(id); }

    public Parents save(Parents parent) { return parentRespository.save(parent); }

    public Parents update(Long id, Parents details) {
        return parentRespository.findById(id).map(existing -> {
            existing.setFullName(details.getFullName());
            existing.setPhone(details.getPhone());
            existing.setEmail(details.getEmail());
            existing.setAddress(details.getAddress());
            return parentRespository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Không tìm thấy Phụ huynh với ID: " + id));
    }

    public void delete(Long id) {
        parentRespository.deleteById(id);
    }

    @Transactional
    public void resetPassword(Long id) {
        Parents parent = parentRespository.findById(id)
                .orElseThrow(()-> new NotFoundException("ko tom thay"));

        User user=userRepository.findByParentId(id)
                .orElseThrow(()-> new BadRequestException("Ch dc cấp tk"));
        String newPassword=passwordEncoder.encode("123456");
        user.setPasswordHash(newPassword);
        userRepository.save(user);
    }
}
