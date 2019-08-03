package ua.lviv.lgs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Level;
import ua.lviv.lgs.domain.Participant;

@Repository
public class ParticipantRepo {
	
	private List<Participant> participants = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		Participant firstParticipant = new Participant();
		firstParticipant.setId(1);
		firstParticipant.setName("Emmy");
		firstParticipant.setEmail("emmy@email.com");
		firstParticipant.setLevel(Level.L1);
		firstParticipant.setPrimarySkill("Beauty");
		
		Participant secondParticipant = new Participant();
		secondParticipant.setId(2);
		secondParticipant.setName("Lora");
		secondParticipant.setEmail("lory@email.com");
		secondParticipant.setLevel(Level.L3);
		secondParticipant.setPrimarySkill("Beauty");
		
		Participant thirdParticipant = new Participant();
		thirdParticipant.setId(3);
		thirdParticipant.setName("Betty");
		thirdParticipant.setEmail("betty@email.com");
		thirdParticipant.setLevel(Level.L5);
		thirdParticipant.setPrimarySkill("Power");
		
		Participant forthParticipant = new Participant();
		forthParticipant.setId(4);
		forthParticipant.setName("Hugo");
		forthParticipant.setEmail("hogo@email.com");
		forthParticipant.setLevel(Level.L3);
		forthParticipant.setPrimarySkill("Knowledge");
		
		Participant fifthParticipant = new Participant();
		fifthParticipant.setId(5);
		fifthParticipant.setName("Britney");
		fifthParticipant.setEmail("brit@email.com");
		fifthParticipant.setLevel(Level.L2);
		fifthParticipant.setPrimarySkill("Language");
		
		Participant sixParticipant = new Participant();
		sixParticipant.setId(1);
		sixParticipant.setName("Tom");
		sixParticipant.setEmail("tom@email.com");
		sixParticipant.setLevel(Level.L4);
		sixParticipant.setPrimarySkill("Power");
		
		participants.add(firstParticipant);
		participants.add(secondParticipant);
		participants.add(thirdParticipant);
		participants.add(forthParticipant);
		participants.add(fifthParticipant);
		participants.add(sixParticipant);
	}
	
	public List<Participant> findAllParticipants(){
		return participants;
	}
	
	public Participant findOne(int id) {
		return participants.stream().filter(participant -> participant.getId() == id).findFirst().orElse(null);
	}
	
	public void save(Participant participant) {
		Participant participantToUpdate = null;
		
		if(participant.getId() != null) {
			participantToUpdate = findOne(participant.getId());
			int participantIndex = participants.indexOf(participantToUpdate);
			participantToUpdate.setName(participant.getName());
			participantToUpdate.setEmail(participant.getEmail());
			participantToUpdate.setLevel(participant.getLevel());
			participantToUpdate.setPrimarySkill(participant.getPrimarySkill());
			participants.set(participantIndex, participantToUpdate);
		}else {
			participant.setId(participants.size()+1);
			participants.add(participant);
		}
	}
	
	public void delete(int id) {
		Iterator<Participant> iterator = participants.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getId() == id) {
				iterator.remove();
			}
		}
	}

}
