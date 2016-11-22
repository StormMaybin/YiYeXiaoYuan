package com.yiyexiaoyuan.formbean;

import java.util.LinkedHashMap;
import java.util.Map;

public class InformationForm
{
	//存储错误信息的
	private Map<String, String> errors = new LinkedHashMap<String, String>();
	//开始地点
	private String startPos;
	//到达地点
	private String arrivePos;
	//开始日期
	private String startDate;
	//下限时间的小时值
	private String startTime_min_hour;
	//下限时间的分钟值
	private String startTime_min_min;
	//上限时间的小时值
	private String startTime_max_hour;
	//上限时间的分钟值
	private String startTime_max_min;
	//最大成员数
	private String maxMember;
	//已有成员数
	private String curtMember;
	//拼车信息备注
	private String message;

	public String getStartPos()
	{
		return this.startPos;
	}

	public void setStartPos(String startPos)
	{
		this.startPos = startPos;
	}

	public String getArrivePos()
	{
		return this.arrivePos;
	}

	public void setArrivePos(String arrivePos)
	{
		this.arrivePos = arrivePos;
	}

	public String getStartDate()
	{
		return this.startDate;
	}

	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}

	public String getStartTime_min_hour()
	{
		return this.startTime_min_hour;
	}

	public void setStartTime_min_hour(String startTime_min_hour)
	{
		this.startTime_min_hour = startTime_min_hour;
	}

	public String getStartTime_min_min()
	{
		return this.startTime_min_min;
	}

	public void setStartTime_min_min(String startTime_min_min)
	{
		this.startTime_min_min = startTime_min_min;
	}

	public String getStartTime_max_hour()
	{
		return this.startTime_max_hour;
	}

	public void setStartTime_max_hour(String startTime_max_hour)
	{
		this.startTime_max_hour = startTime_max_hour;
	}

	public String getStartTime_max_min()
	{
		return this.startTime_max_min;
	}

	public void setStartTime_max_min(String startTime_max_min)
	{
		this.startTime_max_min = startTime_max_min;
	}

	public String getMaxMember()
	{
		return this.maxMember;
	}

	public void setMaxMember(String maxMember)
	{
		this.maxMember = maxMember;
	}

	public String getCurtMember()
	{
		return this.curtMember;
	}

	public void setCurtMember(String curtMember)
	{
		this.curtMember = curtMember;
	}

	public String getMessage()
	{
		return this.message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Map<String, String> getErrors()
	{
		return this.errors;
	}

	public void setErrors(Map<String, String> errors)
	{
		this.errors = errors;
	}

	public boolean checked()
	{
		boolean isOk = true;

		if (this.startPos.equals(this.arrivePos))
		{
			isOk = false;
			this.errors.put("pos", "开始地点和到达地点不能相同");
			return isOk;
		}

		if (!this.startTime_max_hour.matches("[0-9]{1,2}"))
		{
			isOk = false;
			this.errors.put("startTime", "开始时间输入格式有误");
			return isOk;
		}

		if (Integer.parseInt(this.startTime_max_hour) < Integer
				.parseInt(this.startTime_min_hour))
		{
			isOk = false;
			this.errors.put("startTime", "开始时间输入有误");
			return isOk;
		}
		if (Integer.parseInt(this.startTime_max_hour) == Integer
				.parseInt(this.startTime_min_hour))
		{
			if (Integer.parseInt(this.startTime_max_min) < Integer
					.parseInt(this.startTime_min_min))
			{
				isOk = false;
				this.errors.put("startTime", "开始时间输入有误");
				return isOk;
			}
		}
		if (!this.maxMember.matches("[0-9]{1}"))
		{
			isOk = false;
			this.errors.put("maxMember", "请输入正确的最大人数(最大为6,最小为1)");
			return isOk;
		}
		if ((Integer.parseInt(this.maxMember) > 6)
				|| (Integer.parseInt(this.maxMember) <= 0))
		{
			isOk = false;
			this.errors.put("maxMember", "最大人数不能大于6人，并且不能少于1人");
			return isOk;
		}
		if (!this.curtMember.matches("[0-9]{1}"))
		{
			isOk = false;
			this.errors.put("maxMember", "请输入正确的实际人数(最大为6,最小为1)");
			return isOk;
		}
		if ((Integer.parseInt(this.curtMember) > 6)
				|| (Integer.parseInt(this.curtMember) <= 0))
		{
			isOk = false;
			this.errors.put("curtMember", "实际人数不能大于6人，并且不能少于1人");
			return isOk;
		}
		return isOk;
	}
}