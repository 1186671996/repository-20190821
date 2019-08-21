<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>订单管理页面 >> 订单添加页面</span>
        </div>
        <div class="providerAdd">
            <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/useraddsave.do"
             enctype="multipart/form-data">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="billCode">账单编码：</label>
                    <input type="text" name="billCode" id="billCode" value=""> 
					<!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label for="productName">商品名称：</label>
                    <input type="text" name="productName" id="productName" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="productDesc">商品描述：</label>
                    <input type="text" name="productDesc" id="productDesc" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="ruserPassword">商品单位：</label>
                    <input type="text" name="productUnit" id="productUnit" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="totalPrice">商品数量：</label>
                    <input type="text" name="totalPrice" id="totalPrice" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="creationDate">创建时间：</label>
                   <input type="text" name="creationDate" id="creationDate"  value="">
                </div>
                <div class="providerAddBtn">
                    <input type="button" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </form>
        </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/billadd.js"></script>
