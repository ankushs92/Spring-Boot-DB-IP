package in.ankushs.webdbip.service.impl

import in.ankushs.dbip.api.DbIpClient
import in.ankushs.dbip.api.GeoEntity
import in.ankushs.webdbip.service.GeoIpLookupService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GeoIpLookupServiceImpl implements GeoIpLookupService {
	
	//========== ~ Dependencies ~ =====
	private final DbIpClient dbIpClient
	
	@Autowired
	def GeoIpLookupServiceImpl(DbIpClient dbIpClient){
		this.dbIpClient = dbIpClient
	}
	//=================================
	
	@Override
	 GeoEntity lookup(String ip) {
		dbIpClient.lookup(ip)
	}
}
