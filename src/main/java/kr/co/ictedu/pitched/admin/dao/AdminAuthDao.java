package kr.co.ictedu.pitched.admin.dao;

import kr.co.ictedu.pitched.admin.dto.AdminAuthDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface AdminAuthDao {
    /**
     * Finds an admin by username. The SQL query for this is in mappers/AdminMapper.xml
     * @param username The username to search for.
     * @return An Optional containing the Admin if found.
     */
    Optional<AdminAuthDto> findByUsername(@Param("username") String username);
}
