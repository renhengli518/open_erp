<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/static/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="/static/css/uploadfile.css" rel="stylesheet"> 
<script src="/static/js/jquery.uploadfile.js"></script>
<script src="/static/js/malsup.github.iojquery.form.js"></script>

<script type="text/javascript" charset="utf-8" src="/static/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/static/js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="employeeAddForm" class="employeeForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>员工编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="empId" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>员工姓名:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="empName" data-options="required:true"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>性别:</td>
	            <td>
	            	<select id="cc" class="easyui-combobox" name="sex" panelHeight="auto" 
	            		data-options="required:true,width:150, editable:false">
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
    			</td>  
	        </tr>
	        <tr>
	            <td>所属部门:</td>
	            <td>
	            	<input class="easyui-combobox" name="departmentId"   
    					data-options="valueField:'departmentId',textField:'departmentName',
    						url:'department/get_data', editable:false, required:true" />
    			</td>  
	        </tr>
	        <tr>
	            <td>身份证号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="idCode"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>学历:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="education"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>学位:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="degree"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>专业:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="major"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>受教育形式:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="educationForm"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>生日:</td>
	            <td><input class="easyui-datebox" name="birthday"     
        			value="5/5/2016" style="width:150px"> </td>
	        </tr>
	        <tr>
	            <td>入职日期:</td>
	            <td><input class="easyui-datebox" name="joinDate"     
        			value="5/5/2016" style="width:150px"> </td>
	        </tr>
	        <tr>
	            <td>员工状态:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="status"/>
    			</td>  
	        </tr>
	    </table>
	    <input type="hidden" name="employeeParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitEmployeeAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearEmployeeAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	//提交表单
	function submitEmployeeAddForm(){
		//有效性验证
		if(!$('#employeeAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		//ajax的post方式提交表单
		//$("#employeeAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("employee/insert",$("#employeeAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增员工成功!');
				clearEmployeeAddForm();
				$("#employeeAddWindow").window('close');
				$("#employeeList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearEmployeeAddForm(){
		$('#employeeAddForm').form('reset');
	}
</script>
