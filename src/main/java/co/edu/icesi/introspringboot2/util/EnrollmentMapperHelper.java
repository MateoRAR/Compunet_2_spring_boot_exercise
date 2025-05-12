package co.edu.icesi.introspringboot2.util;

import co.edu.icesi.introspringboot2.entity.Enrollment;
import co.edu.icesi.introspringboot2.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnrollmentMapperHelper {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public List<Enrollment> mapIdsToEnrollments(List<Long> ids) {
        if (ids == null) return null;
        return ids.stream()
                .map(id -> enrollmentRepository.findById(id).orElseThrow(() ->
                        new IllegalArgumentException("Enrollment not found with id: " + id)))
                .collect(Collectors.toList());
    }

    public List<Long> mapEnrollmentsToIds(List<Enrollment> enrollments) {
        if (enrollments == null) return null;
        return enrollments.stream()
                .map(Enrollment::getId)
                .collect(Collectors.toList());
    }
}
