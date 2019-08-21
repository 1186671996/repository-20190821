<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
 <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>账单编码：</strong><span>${bill.billCode }</span></p>
            <p><strong>商品名称：</strong><span>${bill.productName }</span></p>
            <p><strong>商品名称：</strong><span>${bill.productDesc }</span></p>
            <p><strong>商品单位：</strong><span>${bill.productUnit }</span></p>
            <p><strong>商品数量：</strong><span>${bill.productCount }</span></p>
            <p><strong>创建时间：</strong><span>${bill.totalPrice }</span></p>
			<div class="providerAddBtn">
            	<input type="button" id="back" name="back" value="返回" >
            </div>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userview.js"></script>