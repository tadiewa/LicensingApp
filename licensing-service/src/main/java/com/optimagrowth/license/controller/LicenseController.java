/**
 * @author : tadiewa
 * date: 9/9/2024
 */


package com.optimagrowth.license.controller;

import com.optimagrowth.license.model.License;
import com.optimagrowth.license.service.LicenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Slf4j
@RestController
@RequestMapping(value="v1/organization/{organizationId}/license")
public class LicenseController {

    @Autowired
    private LicenseService licenseService;

    @GetMapping(value="/{licenseId}")
    public ResponseEntity<License> getLicense(
            @PathVariable("organizationId") String organizationId,
            @PathVariable("licenseId") String licenseId){
        log.info("##############################################################{}",organizationId);

               License license = licenseService
                       .getLicense(licenseId,organizationId)  ;
               return ResponseEntity.ok(license);
    }

    @PutMapping
    public ResponseEntity<License> updateLicense(
            @PathVariable("organizationId") String organizationId,
            @RequestBody License request){
        return ResponseEntity.ok(licenseService.updateLicense(request));
    }

    @PostMapping
    public ResponseEntity<License> createLicense(
            @PathVariable("organizationId") String organizationId,
            @RequestBody License request ,
            @RequestHeader (value = "Accept-Language" , required = false)
                    Locale locale){
        return ResponseEntity.ok(licenseService.createLicense(request));
    }

    @DeleteMapping(value="/{licenseId}")
    public ResponseEntity<String> deleteLicense(
            @PathVariable("organizationId") String organizationId,
            @PathVariable("licenseId") String licenseId) {
        return ResponseEntity.ok(licenseService.deleteLicense(licenseId));
    }
    @RequestMapping(value="/{licenseId}/{clientType}", method = RequestMethod.GET)
    public License getLicensesWithClient(
            @PathVariable("organizationId") String organizationId,
            @PathVariable("licenseId") String licenseId,
            @PathVariable("clientType") String clientType) {
        return licenseService.getLicense(organizationId, licenseId, clientType);
    }

}
