package org.rhl.open_erp.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.rhl.open_erp.service.PictureService;
import org.rhl.open_erp.util.FileUtil;
import org.rhl.open_erp.util.IDUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PictureServiceImpl implements PictureService {

	@Override
	public Map<String, Object> uploadPicture(MultipartFile uploadFile, String filePath) throws Exception {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {

			if (uploadFile != null && uploadFile.getOriginalFilename() != null
					&& uploadFile.getOriginalFilename().length() > 0) {

				// 生成一个新的文件名
				// 取原始文件名
				String oldName = uploadFile.getOriginalFilename();

				// 生成新文件名
				// UUID.randomUUID();
				String newName = IDUtils.genImageName();

				newName = newName + oldName.substring(oldName.lastIndexOf("."));

				// String filePath = "D:\\upload\\temp\\img\\";

				// 新文件
				File file = new java.io.File(filePath + newName);

				// 将内存中的文件写入磁盘
				uploadFile.transferTo(file);

				// 图片上传成功后，将图片的地址写回
				resultMap.put("error", 0);
				resultMap.put("url", "/image/upload/" + newName);
				return resultMap;

			} else {
				// 返回结果
				resultMap.put("error", 1);
				resultMap.put("message", "文件异常");
				return resultMap;
			}
		} catch (Exception e) {
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传发生异常");
			return resultMap;
		}
	}

	@Override
	public boolean deleteFile(String picName, String filePath) throws Exception {

		picName = picName.substring(picName.lastIndexOf("/") + 1);

		picName = filePath + File.separator + picName;

		FileUtil.deleteFile(picName);

		return true;
	}
}
