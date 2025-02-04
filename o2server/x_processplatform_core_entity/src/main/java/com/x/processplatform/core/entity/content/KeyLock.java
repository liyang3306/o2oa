package com.x.processplatform.core.entity.content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.openjpa.persistence.jdbc.Index;

import com.x.base.core.entity.JpaObject;
import com.x.base.core.entity.SliceJpaObject;
import com.x.base.core.entity.annotation.CheckPersist;
import com.x.base.core.entity.annotation.ContainerEntity;
import com.x.base.core.project.annotation.FieldDescribe;
import com.x.processplatform.core.entity.PersistenceProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "KeyLock", description = "流程平台抢办锁定.")
@Entity
@ContainerEntity(dumpSize = 200, type = ContainerEntity.Type.content, reference = ContainerEntity.Reference.strong)
@Table(name = PersistenceProperties.Content.KeyLock.table, uniqueConstraints = {
		@UniqueConstraint(name = PersistenceProperties.Content.KeyLock.table + JpaObject.IndexNameMiddle
				+ JpaObject.DefaultUniqueConstraintSuffix, columnNames = { JpaObject.IDCOLUMN,
						JpaObject.CREATETIMECOLUMN, JpaObject.UPDATETIMECOLUMN, JpaObject.SEQUENCECOLUMN }) })
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class KeyLock extends SliceJpaObject {

	private static final long serialVersionUID = -5448210797584958826L;
	private static final String TABLE = PersistenceProperties.Content.KeyLock.table;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@FieldDescribe("数据库主键,自动生成.")
	@Id
	@Column(length = length_id, name = ColumnNamePrefix + id_FIELDNAME)
	private String id = createId();

	/* 以上为 JpaObject 默认字段 */

	public void onPersist() throws Exception {
	}

	/* 更新运行方法 */

	public KeyLock() {
	}

	public KeyLock(String key, String person) {
		this.key = key;
		this.person = person;
	}

	public static final String key_FIELDNAME = "key";
	@FieldDescribe("锁值.")
	@Column(length = JpaObject.length_255B, name = ColumnNamePrefix + key_FIELDNAME)
	@Index(name = TABLE + IndexNameMiddle + key_FIELDNAME)
	@CheckPersist(allowEmpty = false)
	private String key;

	public static final String person_FIELDNAME = "person";
	@FieldDescribe("人员.")
	@Column(length = length_255B, name = ColumnNamePrefix + person_FIELDNAME)
	@Index(name = TABLE + IndexNameMiddle + person_FIELDNAME)
	@CheckPersist(allowEmpty = false)
	private String person;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

}