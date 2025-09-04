package kr.co.ictedu.pitched.admin.dao;

import kr.co.ictedu.pitched.client.dto.ServiceData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * This mapper interface is specifically for Admin operations on the ORACLE database.
 * The SQL queries for these methods are located in mappers/AdminOracleMapper.xml.
 * Notice that it is in the 'admin.mapper' package, but it will be configured
 * to use the Oracle data source.
 */
@Mapper
public interface AdminOracleDao {

    /**
     * Finds a list of service data entries based on a search term.
     * This is a sample query an admin might run.
     * @param name The search term to filter by.
     * @return A list of matching ServiceData objects.
     */
    List<ServiceData> findServiceDataByName(@Param("name") String name);

    /**
     * An example of a data modification query an admin might perform.
     * This would delete a record from the Oracle database.
     * @param id The ID of the record to delete.
     * @return The number of rows affected.
     */
    int deleteServiceDataById(@Param("id") Long id);
}
