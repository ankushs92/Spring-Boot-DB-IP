package in.ankushs.webdbip.controller

import in.ankushs.dbip.exceptions.InvalidIPException
import in.ankushs.webdbip.resource.ErrorMessage
import in.ankushs.webdbip.service.GeoIpLookupService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("geoip/lookup")
class GeoIpController {
	//============ ~ Dependencies ~ =======================
	private final GeoIpLookupService geoIpLookupService
	
	@Autowired
	def GeoIpController(GeoIpLookupService geoIpLookupService){
		this.geoIpLookupService = geoIpLookupService
	}
	//=====================================================
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<?> getGeoEntity(@RequestParam(required=true) String ip){
		new ResponseEntity(geoIpLookupService.lookup(ip),HttpStatus.OK)
	}
	
	@ExceptionHandler(InvalidIPException)
	def getErrors(){
		new ErrorMessage(field:"ip",msg:"Invalid IP address")
	}

}
