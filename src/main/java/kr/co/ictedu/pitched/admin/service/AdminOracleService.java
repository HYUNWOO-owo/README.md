package kr.co.ictedu.pitched.admin.service;

import kr.co.ictedu.pitched.admin.dao.AdminOracleDao;
import kr.co.ictedu.pitched.client.dto.ServiceData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminOracleService {

    private final AdminOracleDao adminOracleDao;

    public List<ServiceData> searchData(String searchTerm) {
        return adminOracleDao.findServiceDataByName(searchTerm);
    }

    // Use the oracle transaction manager for this service's transactions
    @Transactional("oracleTransactionManager")
    public boolean deleteData(Long id) {
        int rowsAffected = adminOracleDao.deleteServiceDataById(id);
        return rowsAffected > 0;
    }
}
