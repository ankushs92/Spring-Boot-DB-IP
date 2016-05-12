package in.ankushs.webdbip.service

import in.ankushs.dbip.api.GeoEntity

interface GeoIpLookupService {
	GeoEntity lookup(String ip)
}
