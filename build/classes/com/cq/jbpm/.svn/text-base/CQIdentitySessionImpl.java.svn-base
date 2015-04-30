package com.cq.jbpm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.jbpm.api.JbpmException;
import org.jbpm.api.identity.Group;
import org.jbpm.api.identity.User;
import org.jbpm.pvm.internal.env.BasicEnvironment;
import org.jbpm.pvm.internal.id.DbidGenerator;
import org.jbpm.pvm.internal.identity.spi.IdentitySession;

import com.cq.table.CQGroup;
import com.cq.table.CQMemberShip;
import com.cq.table.CQUser;
import com.cq.util.tools;

public class CQIdentitySessionImpl implements IdentitySession {
	protected Session session;
	
	public CQIdentitySessionImpl() {
		this.session = BasicEnvironment.getFromCurrent(Session.class);
	}

	@Override
	public String createGroup(String id, String name, String leader) {
		CQGroup group = new CQGroup();
		
		group.setId(id);
		if (name == null) {
			group.setName(id);
		} else {
			group.setName(name);
		}
		
		if (leader != null) {
			CQUser user = (CQUser)findUserById(leader);
			group.setLeader(user);
		}
		long kid = BasicEnvironment.getFromCurrent(DbidGenerator.class).getNextId();
		group.setKid(kid);
		session.save(group);
		
		return group.getId();
	}

	@Override
	public void createMembership(String userid, String groupid, String tpid) {
		CQUser user = (CQUser) findUserById(userid);
		if (user == null) {
			throw new JbpmException("User does not exist");
		}
		
		CQGroup group = (CQGroup) findGroupById(groupid);
		if (group == null) {
			throw new JbpmException("Group does not exist");
		}
		
		CQMemberShip ms = new CQMemberShip();
		ms.setUser(user);
		ms.setGroup(group);
		int kid = (int) BasicEnvironment.getFromCurrent(DbidGenerator.class).getNextId();
		ms.setKid(kid);
		session.save(ms);
	}

	@Override
	public String createUser(String id, String name, String email, String pwd) {
		String password = null;
		CQUser user = new CQUser();
		
		user.setId(id);
		if (name == null) {
			user.setName(id);
		} else {
			user.setName(name);
		}
		if (pwd == null || pwd.trim().equals("")) {
			password = tools.md5("password");
		} else {
			password = pwd;
		}
		user.setPassword(password);
		user.setEmail(email);
		
		Date da = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String time = sdf.format(da);
		user.setModdate(time);
		
		long kid = BasicEnvironment.getFromCurrent(DbidGenerator.class).getNextId();
		user.setKid((int)kid);
		session.save(user);
		
		return user.getId();
	}

	@Override
	public void deleteGroup(String id) {
		CQGroup group = findGroupById(id);
		session.delete(group);
	}

	@Override
	public void deleteMembership(String userid, String groupid, String arg2) {
		CQMemberShip ms = (CQMemberShip) session.createQuery(" from "
				+ CQMemberShip.class.getName() 
				+ " as ms where ms.user.id = :userid and ms.group.name = :groupid").
				setString("userid", userid).setString("groupid", groupid).uniqueResult();
		session.delete(ms);
	}

	@Override
	public void deleteUser(String id) {
		CQUser user = (CQUser) findUserById(id);
		session.delete(user);
	}

	@Override
	public CQGroup findGroupById(String name) {
		return (CQGroup) session.createCriteria(CQGroup.class).add(Restrictions.eq("name", name)).uniqueResult();
	}

	@Override
	public List<Group> findGroupsByUser(String userid) {
		List<Group> gl = session.createCriteria(CQMemberShip.class)
				.createAlias("user", "u")
				.add(Restrictions.eq("u.id", userid))
				.setProjection(Projections.property("group")).list();
		/*session.createQuery("ms.group from "
				+ CQMemberShip.class.getName() 
				+ " as ms where ms.user.id=:id").setString("id", userid).list();*/
		return gl;
	}

	@Override
	public List<Group> findGroupsByUserAndGroupType(String arg0, String arg1) {
		return null;
	}

	@Override
	public User findUserById(String id) {
		return (User) session.createCriteria(CQUser.class).add(Restrictions.eq("name", id)).uniqueResult();
	}

	@Override
	public List<User> findUsers() {
		return (List<User>) session.createCriteria(CQUser.class).list();
	}

	@Override
	public List<User> findUsersByGroup(String groupid) {
		return session.createCriteria(CQMemberShip.class)
			.createAlias("group", "g")
			.add(Restrictions.eq("g.id", groupid))
			.setProjection(Projections.property("user")).list();
	}

	@Override
	public List<User> findUsersById(String... userids) {
		List<User> userList = session.createCriteria(CQUser.class).add(Restrictions.in("name", userids)).list();
		
		if (userList.size() != userids.length) {
			throw new JbpmException("There are errors in database");
		}
		return userList;
	}

	public List<User> findUsersByWildId(String id) {
		List<User> userList = session.createCriteria(CQUser.class).add(Restrictions.ilike("id", id, MatchMode.ANYWHERE)).list();
		
		return userList;
	}
}
