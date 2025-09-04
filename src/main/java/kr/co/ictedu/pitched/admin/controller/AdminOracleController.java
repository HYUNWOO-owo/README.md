package kr.co.ictedu.pitched.admin.controller;

import kr.co.ictedu.pitched.admin.service.AdminOracleService;
import kr.co.ictedu.pitched.client.dto.ServiceData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/data") // A new endpoint for admin data operations
@RequiredArgsConstructor
public class AdminOracleController {

    private final AdminOracleService adminOracleService;

    /**
     * This endpoint would be protected by Spring Security.
     * An authenticated admin can call this to search for data in the Oracle DB.
     */
    @GetMapping("/search")
    public ResponseEntity<List<ServiceData>> searchServiceData(@RequestParam String query) {
        List<ServiceData> results = adminOracleService.searchData(query);
        return ResponseEntity.ok(results);
    }

    /**
     * This endpoint would also be protected.
     * An admin can call this to delete data from the Oracle DB.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteServiceData(@PathVariable Long id) {
        boolean success = adminOracleService.deleteData(id);
        if (success) {
            return ResponseEntity.ok(Map.of("message", "Data with ID " + id + " deleted successfully."));
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "Data with ID " + id + " not found."));
        }
    }
}
