package com.springschedulardemo.entity;

public class BuildFileInfo {

	private int buildId;
	private String Filename;
	private String versionId;

	public BuildFileInfo() {

	}

	public BuildFileInfo(int buildId, String filename, String versionId) {
		super();
		this.buildId = buildId;
		Filename = filename;
		this.versionId = versionId;
	}

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public String getFilename() {
		return Filename;
	}

	public void setFilename(String filename) {
		Filename = filename;
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	@Override
	public String toString() {
		return "BuildFileInfo [buildId=" + buildId + ", Filename=" + Filename + ", versionId=" + versionId + "]";
	}

}
