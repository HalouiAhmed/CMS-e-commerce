package effyis.partners.socle.content.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import effyis.partners.socle.content.entity.CloudinaryInformation;

public interface CloudinaryUtil {

	default Map uploadGeneric(File file, Cloudinary cloudinary) throws IOException { // Upload to Cloudinary generic method
		return cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
	}

	default void setCloudinaryInfoGeneric(Map uploadResult, CloudinaryInformation information) { // Set Cloudinary informations into entity generic method	 
		information.setPublic_id(uploadResult.get("public_id").toString());
		information.setSecure_url(uploadResult.get("secure_url").toString());
		information.setFormat(uploadResult.get("format").toString());
		information.setBytes(Integer.parseInt(uploadResult.get("bytes").toString()));
		information.setResource_type(uploadResult.get("resource_type").toString());
	}
}
