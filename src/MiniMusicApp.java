import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;


public class MiniMusicApp {

	public static void main(String[] args) {
		
	}
	
	public void play() {
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();//取得Sequencer并打开
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);//创建新的Sequence
			
			Track track = seq.createTrack();//要求取得Track
			
			//对track加入两个MidiEvent
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, 44,100);//四个参数分别为类型、频道、音符、音道
			MidiEvent noteOn = new MidiEvent(a, 1);//第一拍启动a这个messsge
			/**
			 * track带有全部的MidiEvent对象，Sequence会跟是事件时间组织他们
			 * 然后Sequencer会根据此顺序来播放，同一时间可以执行多个操作。
			 */
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			a.setMessage(128, 1, 44,100);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);
			
			player.setSequence(seq);//将Sequence加到Sequencer上
			player.start();//开始播放
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//关闭播放
}//关闭类
