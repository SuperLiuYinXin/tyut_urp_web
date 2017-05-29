package com.liuyinxin.grade.utils.re;

import org.junit.Test;

/**
 * @Author LiuYinXin
 * Created at 2017/5/26.22:26.
 */
public class EvaluateReUtilsTest {

    String context = "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<script type=\"text/javascript\" src=\"/dwr/interface/ajaxtool.js\"></script>\n" +
            "<script type=\"text/javascript\" src=\"/dwr/engine.js\"></script>\n" +
            "<script type=\"text/javascript\" src=\"/dwr/util.js\" ></script>\n" +
            "<html>\n" +
            "<head>\n" +
            "<title>\n" +
            "学生评估问卷列表\n" +
            "</title>\n" +
            "<link href=\"/css/newcss/project.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
            "</head>\n" +
            "<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\" onload=\"unload()\" style=\"overflow:auto;\">\n" +
            "<form name=\"WjList\" method=\"POST\" action=\"jxpgXsAction.do\">\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t\n" +
            "\t\t<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\"\n" +
            "\t\t\tcellspacing=\"0\">\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td class=\"Linetop\"></td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t</table>\n" +
            "\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
            "\t\t\tclass=\"title\" id=\"tblHead\">\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td width=\"80%\">\n" +
            "\t\t\t\t\t<table border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\n" +
            "\n" +
            "\t\t\t\t\t\t<tr>\n" +
            "\t\t\t\t\t\t\t<td>\n" +
            "\t\t\t\t\t\t\t\t&nbsp;\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t<td valign=\"middle\">\n" +
            "\t\t\t\t\t\t\t\t&nbsp;\n" +
            "\t\t\t\t\t\t\t\t<b>列表</b> &nbsp;\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t</tr>\n" +
            "\t\t\t\t\t</table>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t\t<td width=\"20%\">\n" +
            "\n" +
            "\t\t\t\t\t<table border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\"\n" +
            "\t\t\t\t\t\twidth=\"100%\">\n" +
            "\n" +
            "\t\t\t\t\t\t<tr>\n" +
            "\t\t\t\t\t\t\t<td>\n" +
            "\t\t\t\t\t\t\t\t&nbsp;\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\n" +
            "\t\t\t\t\t\t\t<td width=\"3\">\n" +
            "\t\t\t\t\t\t\t\t&nbsp;\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t<td width=\"10\" align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t&nbsp;\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t<td width=\"3\">\n" +
            "\t\t\t\t\t\t\t\t&nbsp;\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\n" +
            "\n" +
            "\t\t\t\t\t\t\t<td width=\"5\"></td>\n" +
            "\t\t\t\t\t\t</tr>\n" +
            "\t\t\t\t\t</table>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t</table>\n" +
            "\t\t<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\"\n" +
            "\t\t\tcellspacing=\"0\">\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td class=\"Linetop\"></td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t</table>\n" +
            "\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
            "\t\t\tclass=\"titleTop2\">\n" +
            "\t\t\t\t<input name=\"wjbm\" type=\"hidden\" value=\"\">\n" +
            "\t\t\t\t<input name=\"bpr\" type=\"hidden\" value=\"\">\n" +
            "\t\t\t\t<input name=\"pgnr\" type=\"hidden\" value=\"\">\n" +
            "\t\t\t\t<input name=\"oper\" type=\"hidden\" value=\"\">\n" +
            "\t\t\t\t<input name=\"wjmc\" type=\"hidden\" value=\"\">\n" +
            "\t\t\t\t<input name=\"bprm\" type=\"hidden\" value=\"\">\n" +
            "\t\t\t\t<input name=\"pgnrm\" type=\"hidden\" value=\"\">\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td class=\"pageAlign\">\n" +
            "\t\t\t\t\t<table cellpadding=\"0\" width=\"100%\" class=\"displayTag\"\n" +
            "\t\t\t\t\t\tcellspacing=\"1\" border=\"0\" id=\"user\">\n" +
            "\t\t\t\t\t\t<thead>\n" +
            "\t\t\t\t\t\t\t<tr>\n" +
            "\n" +
            "\t\t\t\t\t\t\t\t<th width=\"10%\" class=\"sortable\" align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t\t问卷名称\n" +
            "\t\t\t\t\t\t\t\t</th>\n" +
            "\t\t\t\t\t\t\t\t<th width=\"10%\" class=\"sortable\" align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t\t被评人\n" +
            "\t\t\t\t\t\t\t\t</th>\n" +
            "\t\t\t\t\t\t\t\t<th width=\"50%\" class=\"sortable\" align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t\t评估内容\n" +
            "\t\t\t\t\t\t\t\t</th>\n" +
            "\t\t\t\t\t\t\t\t<th width=\"10%\" class=\"sortable\" align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t\t是否已评估\n" +
            "\t\t\t\t\t\t\t\t</th>\n" +
            "\t\t\t\t\t\t\t\t<th width=\"10%\" class=\"sortable\" align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t\t操作\n" +
            "\t\t\t\t\t\t\t\t</th>\n" +
            "\t\t\t\t\t\t\t</tr>\n" +
            "\t\t\t\t\t\t</thead>\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<tr class=\"odd\" onMouseOut=\"this.className='even';\"\n" +
            "\t\t\t\t\t\t\tonMouseOver=\"this.className='evenfocus';\">\n" +
            "\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">2016-2017学年第二学期期末学生评教</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">田添</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">线性代数E</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">是</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t<img name=\"0000000103#@101453#@田添#@2016-2017学年第二学期期末学生评教#@线性代数E#@00003346\" style=\"cursor: hand;\" title=\"查看\"\n" +
            "\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
            "\t\t\t\t\t\t\t\t\tsrc=\"/img/icon/view.gif\"\n" +
            "\t\t\t\t\t\t\t\t\tborder=\"0\" onclick=\"check(this)\">\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t</tr>\n" +
            "\n" +
            "\t\t\t\t\t\t<tr class=\"odd\" onMouseOut=\"this.className='even';\"\n" +
            "\t\t\t\t\t\t\tonMouseOver=\"this.className='evenfocus';\">\n" +
            "\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">2016-2017学年第二学期期末学生评教</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">王鲜霞</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">高等数学E(二)</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">是</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t<img name=\"0000000103#@101476#@王鲜霞#@2016-2017学年第二学期期末学生评教#@高等数学E(二)#@00003554\" style=\"cursor: hand;\" title=\"查看\"\n" +
            "\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
            "\t\t\t\t\t\t\t\t\tsrc=\"/img/icon/view.gif\"\n" +
            "\t\t\t\t\t\t\t\t\tborder=\"0\" onclick=\"check(this)\">\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t</tr>\n" +
            "\n" +
            "\t\t\t\t\t\t<tr class=\"odd\" onMouseOut=\"this.className='even';\"\n" +
            "\t\t\t\t\t\t\tonMouseOver=\"this.className='evenfocus';\">\n" +
            "\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">2016-2017学年第二学期期末学生评教</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">梁志浩</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">体育(二)</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">是</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t<img name=\"0000000103#@101810#@梁志浩#@2016-2017学年第二学期期末学生评教#@体育(二)#@00007002\" style=\"cursor: hand;\" title=\"查看\"\n" +
            "\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
            "\t\t\t\t\t\t\t\t\tsrc=\"/img/icon/view.gif\"\n" +
            "\t\t\t\t\t\t\t\t\tborder=\"0\" onclick=\"check(this)\">\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t</tr>\n" +
            "\n" +
            "\t\t\t\t\t\t<tr class=\"odd\" onMouseOut=\"this.className='even';\"\n" +
            "\t\t\t\t\t\t\tonMouseOver=\"this.className='evenfocus';\">\n" +
            "\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">2016-2017学年第二学期期末学生评教</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">田保花</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">大学英语(二)</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">否</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t<img name=\"0000000103#@101976#@田保花#@2016-2017学年第二学期期末学生评教#@大学英语(二)#@00000012\" style=\"cursor: hand;\" title=\"评估\"\n" +
            "\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
            "\t\t\t\t\t\t\t\t\tsrc=\"/img/icon/edit.gif\"\n" +
            "\t\t\t\t\t\t\t\t\tborder=\"0\" onclick=\"evaluation(this)\">\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t</tr>\n" +
            "\n" +
            "\t\t\t\t\t\t<tr class=\"odd\" onMouseOut=\"this.className='even';\"\n" +
            "\t\t\t\t\t\t\tonMouseOver=\"this.className='evenfocus';\">\n" +
            "\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">2016-2017学年第二学期期末学生评教</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">田保花</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">英语听力(二)</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">否</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t<img name=\"0000000103#@101976#@田保花#@2016-2017学年第二学期期末学生评教#@英语听力(二)#@00000016\" style=\"cursor: hand;\" title=\"评估\"\n" +
            "\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
            "\t\t\t\t\t\t\t\t\tsrc=\"/img/icon/edit.gif\"\n" +
            "\t\t\t\t\t\t\t\t\tborder=\"0\" onclick=\"evaluation(this)\">\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t</tr>\n" +
            "\n" +
            "\t\t\t\t\t\t<tr class=\"odd\" onMouseOut=\"this.className='even';\"\n" +
            "\t\t\t\t\t\t\tonMouseOver=\"this.className='evenfocus';\">\n" +
            "\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">2016-2017学年第二学期期末学生评教</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">吕进来</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">面向对象程序设计基础R</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">否</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t<img name=\"0000000103#@102243#@吕进来#@2016-2017学年第二学期期末学生评教#@面向对象程序设计基础R#@00008479\" style=\"cursor: hand;\" title=\"评估\"\n" +
            "\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
            "\t\t\t\t\t\t\t\t\tsrc=\"/img/icon/edit.gif\"\n" +
            "\t\t\t\t\t\t\t\t\tborder=\"0\" onclick=\"evaluation(this)\">\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t</tr>\n" +
            "\n" +
            "\t\t\t\t\t\t<tr class=\"odd\" onMouseOut=\"this.className='even';\"\n" +
            "\t\t\t\t\t\t\tonMouseOver=\"this.className='evenfocus';\">\n" +
            "\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">2016-2017学年第二学期期末学生评教</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">王丽庆</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">形势与政策</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">否</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t<img name=\"0000000103#@102374#@王丽庆#@2016-2017学年第二学期期末学生评教#@形势与政策#@00007013\" style=\"cursor: hand;\" title=\"评估\"\n" +
            "\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
            "\t\t\t\t\t\t\t\t\tsrc=\"/img/icon/edit.gif\"\n" +
            "\t\t\t\t\t\t\t\t\tborder=\"0\" onclick=\"evaluation(this)\">\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t</tr>\n" +
            "\n" +
            "\t\t\t\t\t\t<tr class=\"odd\" onMouseOut=\"this.className='even';\"\n" +
            "\t\t\t\t\t\t\tonMouseOver=\"this.className='evenfocus';\">\n" +
            "\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">2016-2017学年第二学期期末学生评教</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">杨平</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">大学物理B</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">是</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t<img name=\"0000000103#@103741#@杨平#@2016-2017学年第二学期期末学生评教#@大学物理B#@00000042\" style=\"cursor: hand;\" title=\"查看\"\n" +
            "\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
            "\t\t\t\t\t\t\t\t\tsrc=\"/img/icon/view.gif\"\n" +
            "\t\t\t\t\t\t\t\t\tborder=\"0\" onclick=\"check(this)\">\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t</tr>\n" +
            "\n" +
            "\t\t\t\t\t\t<tr class=\"odd\" onMouseOut=\"this.className='even';\"\n" +
            "\t\t\t\t\t\t\tonMouseOver=\"this.className='evenfocus';\">\n" +
            "\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">2016-2017学年第二学期期末学生评教</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">兰方鹏</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">软件工程教学实习</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">否</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t<img name=\"0000000103#@104189#@兰方鹏#@2016-2017学年第二学期期末学生评教#@软件工程教学实习#@SJ000009\" style=\"cursor: hand;\" title=\"评估\"\n" +
            "\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
            "\t\t\t\t\t\t\t\t\tsrc=\"/img/icon/edit.gif\"\n" +
            "\t\t\t\t\t\t\t\t\tborder=\"0\" onclick=\"evaluation(this)\">\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t</tr>\n" +
            "\n" +
            "\t\t\t\t\t\t<tr class=\"odd\" onMouseOut=\"this.className='even';\"\n" +
            "\t\t\t\t\t\t\tonMouseOver=\"this.className='evenfocus';\">\n" +
            "\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">2016-2017学年第二学期期末学生评教</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">刘文振</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">中国近现代史纲要</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">否</td>\n" +
            "\t\t\t\t\t\t\t<td align=\"center\">\n" +
            "\t\t\t\t\t\t\t\t<img name=\"0000000103#@w120302#@刘文振#@2016-2017学年第二学期期末学生评教#@中国近现代史纲要#@00000004\" style=\"cursor: hand;\" title=\"评估\"\n" +
            "\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
            "\t\t\t\t\t\t\t\t\tsrc=\"/img/icon/edit.gif\"\n" +
            "\t\t\t\t\t\t\t\t\tborder=\"0\" onclick=\"evaluation(this)\">\n" +
            "\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t</tr>\n" +
            "\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\n" +
            "\t\t</table>\n" +
            "\t\t<div align=\"right\">\n" +
            "\t\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" ><tr><td align=\"right\">共10项&nbsp;&nbsp;第1/1页&nbsp;&nbsp;<img title=\"第一页\" src=\"/img/icon/noDownDM2.gif\"style=\"vertical-align:center;\" width=\"11\" height=\"11\" />&nbsp;<img title=\"前一页\" src=\"/img/icon/noDownDM_2.gif\"style=\"vertical-align:center;\" width=\"11\" height=\"11\" /><img title=\"下一页\" src=\"/img/icon/noUpDM_2.gif\"style=\"vertical-align:center;\" width=\"11\" height=\"11\" />&nbsp;<img title=\"最后一页\" src=\"/img/icon/noUpDM2.gif\"style=\"vertical-align:center;\" width=\"11\" height=\"11\" />&nbsp;&nbsp;每页显示的记录数&nbsp;<select name=\"pageSize\" onchange=\"pageSizeChange()\"><option value=\"10\" >10项</option><option value=\"20\" selected='selected'>20项</option><option value=\"30\" >30项</option><option value=\"40\" >40项</option><option value=\"50\" >50项</option><option value=\"100\" >100项</option><option value=\"200\" >200项</option><option value=\"300\" >300项</option></select><input   name=\"page\"   type=\"hidden\"   id=\"page\" value=\"1\">&nbsp;<input   name=\"currentPage\"   type=\"hidden\"   id=\"currentPage\" value=\"1\">&nbsp;<input   name=\"pageNo\"   type=\"text\"   id=\"pageNo\"   size=\"3\"   onKeyPress=\"return   handleEnterOnPageNo();\">&nbsp;<img src=\"/img/icon/go.gif\"  name=\"goto\"  id=\"goto\" style=\"cursor:hand;\" title=\"跳转到\" onClick=\"forward();\"><script   type   =   'text/javaScript'>\n" +
            "function   forward(){     if(!(/^([1-9])(\\d{0,})(\\d{0,})$/.test(document.all.pageNo.value))){         alert(\"请输入合法的页号！\");         document.all.pageNo.focus();         return false;     }     if(document.all.pageNo.value>1     ){     alert(\"输入的页数超过了总页数，请重新输入！\");         document.all.pageNo.focus();         return false;     }         window.location.href=\"/jxpgXsAction.do?totalrows=10&page=\"+   document.all.pageNo.value +\"&pageSize=\"+document.all.pageSize.value;}function   handleEnterOnPageNo(){     if(event.keyCode   ==   13)     {         forward();         return   false;     }     return   true;}function pageSizeChange(){ window.location.href=\"/jxpgXsAction.do?totalrows=10&pageSize=\"+document.all.pageSize.value;}function pagination(value){ window.location.href=\"/jxpgXsAction.do?totalrows=10&page=\"+value+\"&pageSize=\"+document.all.pageSize.value;}</script></td></tr></table>\n" +
            "\t\t</div>\n" +
            "\t\t</form>\n" +
            "\t</body>\n" +
            "</html>\n" +
            "<Script language=\"JavaScript\">\n" +
            "function unload(){\n" +
            "\tajaxtool.getOper(\"listWj\");\n" +
            "}\n" +
            "</Script>\n" +
            "<Script language=\"JavaScript\">\n" +
            "\tfunction check(a){\n" +
            "            var start=0;\n" +
            "                var end;\n" +
            "                var data =a.name;\n" +
            "                end =data.indexOf(\"#@\",start);\n" +
            "                var sub = data.substring(start,end);\n" +
            "                window.document.WjList.wjbm.value=sub;\n" +
            "\n" +
            "                start = end + 2;\n" +
            "                end = data.indexOf(\"#@\",start);\n" +
            "                sub = data.substring(start,end);\n" +
            "                window.document.WjList.bpr.value=sub;\n" +
            "\n" +
            "                start = end + 2;\n" +
            "                end = data.indexOf(\"#@\",start);\n" +
            "                sub = data.substring(start,end);\n" +
            "                window.document.WjList.bprm.value=sub;\n" +
            "\t\t\t\t//alert(\"window.document.WjList.bprm.value\"+sub);\n" +
            "                start = end + 2;\n" +
            "                end = data.indexOf(\"#@\",start);\n" +
            "                sub = data.substring(start,end);\n" +
            "                window.document.WjList.wjmc.value=sub;\n" +
            "\t\t\t\t//alert(\"window.document.WjList.wjmc.value\"+sub);\n" +
            "                start = end + 2;\n" +
            "                end = data.indexOf(\"#@\",start);\n" +
            "                sub = data.substring(start,end);\n" +
            "                window.document.WjList.pgnrm.value=sub;\n" +
            "\t\t\t\t//alert(\"window.document.WjList.pgnrm.value\"+sub);\n" +
            "                start = end + 2;\n" +
            "                sub = data.substring(start);\n" +
            "                window.document.WjList.pgnr.value=sub;\n" +
            "                window.document.WjList.oper.value=\"wjResultShow\";\n" +
            "\n" +
            "            window.document.WjList.submit();\n" +
            "        }\n" +
            "       function evaluation(a){\n" +
            "           \t//alert(a.name);\n" +
            "                var start=0;\n" +
            "                var end;\n" +
            "                var data =a.name;\n" +
            "                end =data.indexOf(\"#@\",start);\n" +
            "                var sub = data.substring(start,end);\n" +
            "                window.document.WjList.wjbm.value=sub;\n" +
            "\n" +
            "                start = end + 2;\n" +
            "                end = data.indexOf(\"#@\",start);\n" +
            "                sub = data.substring(start,end);\n" +
            "                window.document.WjList.bpr.value=sub;\n" +
            "\t\t\t\t//alert(sub);\n" +
            "                start = end + 2;\n" +
            "                end = data.indexOf(\"#@\",start);\n" +
            "                sub = data.substring(start,end);\n" +
            "                window.document.WjList.bprm.value=sub;\n" +
            "\n" +
            "                start = end + 2;\n" +
            "                end = data.indexOf(\"#@\",start);\n" +
            "                sub = data.substring(start,end);\n" +
            "                window.document.WjList.wjmc.value=sub;\n" +
            "\n" +
            "                start = end + 2;\n" +
            "                end = data.indexOf(\"#@\",start);\n" +
            "                sub = data.substring(start,end);\n" +
            "                window.document.WjList.pgnrm.value=sub;\n" +
            "\n" +
            "                start = end + 2;\n" +
            "                sub = data.substring(start);\n" +
            "                window.document.WjList.pgnr.value=sub;\n" +
            "                window.document.WjList.oper.value=\"wjShow\";\n" +
            "                window.document.WjList.submit();\n" +
            "       }\n" +
            "</Script>\n";

    @Test
    public void getEvaluateList() throws Exception {
//        选择的
//        String regex = "(?<=\")(.*?)#@(.*?)#@(.*?)#@(.*?)#@(.*?)#@(.*?)(?=\")|(是(?=</td>)|否(?=</td>))";
        EvaluateReUtils.getEvaluateList(context);
//        for (Evaluate ev:evaluateList ) {
//            System.out.println(ev.toString());
//        }
    }

}