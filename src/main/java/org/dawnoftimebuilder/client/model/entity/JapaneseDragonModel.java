package org.dawnoftimebuilder.client.model.entity;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;
import org.dawnoftimebuilder.entity.JapaneseDragonEntity;

public class JapaneseDragonModel extends EntityModel<JapaneseDragonEntity> {

	private final RendererModel HeadCenter;
	private final RendererModel NoseA;
	private final RendererModel NoseB;
	private final RendererModel NoseC;
	private final RendererModel NoseD;
	private final RendererModel LEye;
	private final RendererModel LEyebrow;
	private final RendererModel REye;
	private final RendererModel REyebrow;
	private final RendererModel JawTop;
	private final RendererModel HeadBottom;
	private final RendererModel LHorneA;
	private final RendererModel LHorneB;
	private final RendererModel RHorneA;
	private final RendererModel RHorneB;
	private final RendererModel LMustaA;
	private final RendererModel RMustaA;
	private final RendererModel BodyA;
	private final RendererModel JawBottom;
	private final RendererModel Tongue;
	private final RendererModel LMustaB;
	private final RendererModel LMustaC;
	private final RendererModel LMustaD;
	private final RendererModel LMustaE;
	private final RendererModel RMustaB;
	private final RendererModel RMustaC;
	private final RendererModel RMustaD;
	private final RendererModel RMustaE;
	private final RendererModel BodyAHorne;
	private final RendererModel BodyB;
	private final RendererModel BodyBHorne;
	private final RendererModel BodyC;
	private final RendererModel BodyCHorne;
	private final RendererModel ShoulderL;
	private final RendererModel ShoulderR;
	private final RendererModel BodyD;
	private final RendererModel HarmL;
	private final RendererModel FingerLA;
	private final RendererModel FingerLB;
	private final RendererModel FingerLC;
	private final RendererModel FingerLAEnd;
	private final RendererModel FingerLBEnd;
	private final RendererModel HarmR;
	private final RendererModel FingerRA;
	private final RendererModel FingerRB;
	private final RendererModel FingerRC;
	private final RendererModel FingerRAEnd;
	private final RendererModel FingerRBEnd;
	private final RendererModel BodyDHorne;
	private final RendererModel BodyE;
	private final RendererModel BodyEHorne;
	private final RendererModel BodyF;
	private final RendererModel BodyFHorne;
	private final RendererModel BodyG;
	private final RendererModel BodyGHorne;
	private final RendererModel BodyH;
	private final RendererModel BodyHHorne;
	private final RendererModel ThighR;
	private final RendererModel ThighL;
	private final RendererModel BodyI;
	private final RendererModel LegR;
	private final RendererModel HeelR;
	private final RendererModel FingerR;
	private final RendererModel LegL;
	private final RendererModel HeelL;
	private final RendererModel FingerL;
	private final RendererModel BodyIHorne;
	private final RendererModel BodyJ;
	private final RendererModel BodyJHorne;
	private final RendererModel BodyK;
	private final RendererModel BodyKHorne;

	public JapaneseDragonModel() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.FingerRAEnd = new RendererModel(this, 32, 2);
		this.FingerRAEnd.setRotationPoint(4.0F, 0.0F, 0.0F);
		this.FingerRAEnd.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
		this.setRotateAngle(FingerRAEnd, 0.0F, 0.0F, 0.8196066167365371F);
		this.BodyH = new RendererModel(this, 0, 0);
		this.BodyH.setRotationPoint(0.0F, 0.0F, 16.0F);
		this.BodyH.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 16, 0.0F);
		this.LMustaD = new RendererModel(this, 18, 45);
		this.LMustaD.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.LMustaD.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 8, 0.0F);
		this.setRotateAngle(LMustaD, 0.0F, -0.4553564018453205F, 0.0F);
		this.FingerRB = new RendererModel(this, 32, 0);
		this.FingerRB.setRotationPoint(1.5F, 0.5F, 10.0F);
		this.FingerRB.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
		this.setRotateAngle(FingerRB, -0.7853981633974483F, -2.0943951023931953F, -0.6108652381980153F);
		this.LegL = new RendererModel(this, 78, 45);
		this.LegL.setRotationPoint(2.5F, 0.0F, 5.5F);
		this.LegL.addBox(0.0F, -1.5F, 0.0F, 3, 3, 6, 0.0F);
		this.setRotateAngle(LegL, 0.0F, 1.2292353921796064F, 3.141592653589793F);
		this.HarmR = new RendererModel(this, 32, 51);
		this.HarmR.setRotationPoint(-2.0F, 0.0F, 10.0F);
		this.HarmR.addBox(0.0F, -1.0F, 0.0F, 2, 2, 10, 0.0F);
		this.setRotateAngle(HarmR, 0.0F, 1.2292353921796064F, 0.0F);
		this.RMustaA = new RendererModel(this, 18, 45);
		this.RMustaA.setRotationPoint(-2.0F, -0.5F, -19.5F);
		this.RMustaA.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 8, 0.0F);
		this.setRotateAngle(RMustaA, 0.0F, 0.0F, 2.792526803190927F);
		this.FingerLBEnd = new RendererModel(this, 32, 2);
		this.FingerLBEnd.setRotationPoint(4.0F, 0.0F, 0.0F);
		this.FingerLBEnd.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
		this.setRotateAngle(FingerLBEnd, 0.0F, 0.0F, -0.9105382707654417F);
		this.LegR = new RendererModel(this, 78, 45);
		this.LegR.setRotationPoint(2.5F, 0.0F, 5.5F);
		this.LegR.addBox(0.0F, -1.5F, 0.0F, 3, 3, 6, 0.0F);
		this.setRotateAngle(LegR, 0.0F, 1.2292353921796064F, 3.141592653589793F);
		this.Tongue = new RendererModel(this, 96, 29);
		this.Tongue.setRotationPoint(3.5F, 3.5F, -14.0F);
		this.Tongue.addBox(0.0F, 0.0F, 0.0F, 3, 2, 11, 0.0F);
		this.setRotateAngle(Tongue, 0.08726646259971647F, 0.0F, 0.0F);
		this.RHorneA = new RendererModel(this, 60, 7);
		this.RHorneA.setRotationPoint(-1.0F, -3.0F, -9.0F);
		this.RHorneA.addBox(0.0F, 0.0F, 0.0F, 3, 10, 3, 0.0F);
		this.setRotateAngle(RHorneA, -1.7453292519943295F, 2.792526803190927F, 0.17453292519943295F);
		this.FingerRA = new RendererModel(this, 32, 0);
		this.FingerRA.setRotationPoint(1.5F, -0.5F, 10.0F);
		this.FingerRA.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
		this.setRotateAngle(FingerRA, 0.7853981633974483F, -2.0943951023931953F, 0.6108652381980153F);
		this.HeelL = new RendererModel(this, 106, 49);
		this.HeelL.setRotationPoint(0.0F, 0.0F, 6.0F);
		this.HeelL.addBox(0.0F, -1.0F, 0.0F, 2, 2, 8, 0.0F);
		this.setRotateAngle(HeelL, 0.0F, 2.231054382824351F, 3.141592653589793F);
		this.FingerLA = new RendererModel(this, 32, 0);
		this.FingerLA.setRotationPoint(1.5F, -0.5F, 10.0F);
		this.FingerLA.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
		this.setRotateAngle(FingerLA, 0.7853981633974483F, -2.0943951023931953F, 0.6108652381980153F);
		this.BodyGHorne = new RendererModel(this, 58, -16);
		this.BodyGHorne.setRotationPoint(0.0F, -6.0F, 0.0F);
		this.BodyGHorne.addBox(0.0F, 0.0F, 0.0F, 0, 2, 16, 0.0F);
		this.REyebrow = new RendererModel(this, 32, 10);
		this.REyebrow.setRotationPoint(-2.0F, -2.5F, -12.5F);
		this.REyebrow.addBox(0.0F, 0.0F, 0.0F, 2, 1, 5, 0.0F);
		this.setRotateAngle(REyebrow, -2.1816615649929116F, -2.6186920096922917F, 2.2689280275926285F);
		this.FingerRC = new RendererModel(this, 0, 14);
		this.FingerRC.setRotationPoint(0.5F, 0.5F, 10.0F);
		this.FingerRC.addBox(0.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(FingerRC, 0.0F, -3.141592653589793F, 0.0F);
		this.LEyebrow = new RendererModel(this, 32, 7);
		this.LEyebrow.setRotationPoint(2.0F, -2.5F, -12.5F);
		this.LEyebrow.addBox(0.0F, 0.0F, 0.0F, 5, 1, 2, 0.0F);
		this.setRotateAngle(LEyebrow, 0.9599310885968813F, -0.5235987755982988F, -0.3490658503988659F);
		this.HeelR = new RendererModel(this, 106, 49);
		this.HeelR.setRotationPoint(0.0F, 0.0F, 6.0F);
		this.HeelR.addBox(0.0F, -1.0F, 0.0F, 2, 2, 8, 0.0F);
		this.setRotateAngle(HeelR, 0.0F, 2.231054382824351F, 3.141592653589793F);
		this.BodyCHorne = new RendererModel(this, 58, -16);
		this.BodyCHorne.setRotationPoint(0.0F, -6.0F, 0.0F);
		this.BodyCHorne.addBox(0.0F, 0.0F, 0.0F, 0, 2, 16, 0.0F);
		this.BodyFHorne = new RendererModel(this, 58, -16);
		this.BodyFHorne.setRotationPoint(0.0F, -6.0F, 0.0F);
		this.BodyFHorne.addBox(0.0F, 0.0F, 0.0F, 0, 2, 16, 0.0F);
		this.BodyAHorne = new RendererModel(this, 58, -16);
		this.BodyAHorne.setRotationPoint(0.0F, -6.0F, 0.0F);
		this.BodyAHorne.addBox(0.0F, 0.0F, 0.0F, 0, 2, 16, 0.0F);
		this.BodyJ = new RendererModel(this, 60, 4);
		this.BodyJ.setRotationPoint(0.0F, 0.0F, 16.0F);
		this.BodyJ.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 16, 0.0F);
		this.REye = new RendererModel(this, 0, 4);
		this.REye.setRotationPoint(-2.0F, -3.0F, -11.5F);
		this.REye.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
		this.setRotateAngle(REye, 0.5235987755982988F, 0.0F, 1.5707963267948966F);
		this.ShoulderR = new RendererModel(this, 86, 44);
		this.ShoulderR.setRotationPoint(-4.0F, 0.0F, 8.0F);
		this.ShoulderR.addBox(-2.0F, -1.5F, 0.0F, 4, 3, 10, 0.0F);
		this.setRotateAngle(ShoulderR, 0.36425021489121656F, 1.3203415791337103F, 1.9577358219620393F);
		this.BodyJHorne = new RendererModel(this, 58, -16);
		this.BodyJHorne.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.BodyJHorne.addBox(0.0F, 0.0F, 0.0F, 0, 2, 16, 0.0F);
		this.RMustaE = new RendererModel(this, 28, 46);
		this.RMustaE.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.RMustaE.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 6, 0.0F);
		this.setRotateAngle(RMustaE, 0.0F, 0.5462880558742251F, 0.0F);
		this.BodyC = new RendererModel(this, 0, 0);
		this.BodyC.setRotationPoint(0.0F, 0.0F, 16.0F);
		this.BodyC.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 16, 0.0F);
		this.NoseC = new RendererModel(this, 0, 8);
		this.NoseC.setRotationPoint(-2.0F, 0.0F, -16.5F);
		this.NoseC.addBox(0.0F, 0.0F, 0.0F, 4, 3, 3, 0.0F);
		this.setRotateAngle(NoseC, 0.7853981633974483F, 0.0F, 0.0F);
		this.RMustaB = new RendererModel(this, 18, 45);
		this.RMustaB.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.RMustaB.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 8, 0.0F);
		this.setRotateAngle(RMustaB, 0.0F, -0.22759093446006054F, 0.0F);
		this.RMustaC = new RendererModel(this, 18, 45);
		this.RMustaC.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.RMustaC.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 8, 0.0F);
		this.setRotateAngle(RMustaC, 0.0F, -0.31869712141416456F, 0.0F);
		this.BodyEHorne = new RendererModel(this, 58, -16);
		this.BodyEHorne.setRotationPoint(0.0F, -6.0F, 0.0F);
		this.BodyEHorne.addBox(0.0F, 0.0F, 0.0F, 0, 2, 16, 0.0F);
		this.HeadCenter = new RendererModel(this, 0, 24);
		this.HeadCenter.setRotationPoint(0.0F, 1.0F, 8.0F);
		this.HeadCenter.addBox(-4.5F, -4.0F, -10.0F, 9, 6, 10, 0.0F);
		this.NoseD = new RendererModel(this, 104, 15);
		this.NoseD.setRotationPoint(-2.0F, 0.0F, -14.0F);
		this.NoseD.addBox(0.0F, 0.0F, 0.0F, 4, 3, 6, 0.0F);
		this.setRotateAngle(NoseD, 0.7853981633974483F, 0.0F, 0.0F);
		this.FingerLC = new RendererModel(this, 0, 14);
		this.FingerLC.setRotationPoint(0.5F, 0.5F, 10.0F);
		this.FingerLC.addBox(0.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(FingerLC, 0.0F, -3.141592653589793F, 0.0F);
		this.BodyDHorne = new RendererModel(this, 58, -16);
		this.BodyDHorne.setRotationPoint(0.0F, -6.0F, 0.0F);
		this.BodyDHorne.addBox(0.0F, 0.0F, 0.0F, 0, 2, 16, 0.0F);
		this.BodyK = new RendererModel(this, 84, 8);
		this.BodyK.setRotationPoint(0.0F, 0.0F, 16.0F);
		this.BodyK.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 16, 0.0F);
		this.LHorneB = new RendererModel(this, 104, 5);
		this.LHorneB.setRotationPoint(4.5F, -5.0F, -1.0F);
		this.LHorneB.addBox(0.0F, 0.0F, 0.0F, 2, 2, 8, 0.0F);
		this.setRotateAngle(LHorneB, 0.17453292519943295F, 0.08726646259971647F, 0.0F);
		this.BodyG = new RendererModel(this, 0, 0);
		this.BodyG.setRotationPoint(0.0F, 0.0F, 16.0F);
		this.BodyG.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 16, 0.0F);
		this.NoseA = new RendererModel(this, 44, 0);
		this.NoseA.setRotationPoint(-2.5F, 0.0F, -22.0F);
		this.NoseA.addBox(0.0F, 0.0F, 0.0F, 5, 4, 4, 0.0F);
		this.setRotateAngle(NoseA, 0.7853981633974483F, 0.0F, 0.0F);
		this.LMustaC = new RendererModel(this, 18, 45);
		this.LMustaC.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.LMustaC.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 8, 0.0F);
		this.setRotateAngle(LMustaC, 0.0F, -0.31869712141416456F, 0.0F);
		this.LMustaE = new RendererModel(this, 28, 46);
		this.LMustaE.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.LMustaE.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 6, 0.0F);
		this.setRotateAngle(LMustaE, 0.0F, 0.5462880558742251F, 0.0F);
		this.ThighR = new RendererModel(this, 56, 51);
		this.ThighR.setRotationPoint(-4.0F, 0.0F, 8.0F);
		this.ThighR.addBox(-2.5F, -2.0F, -2.5F, 5, 4, 8, 0.0F);
		this.setRotateAngle(ThighR, 0.18203784098300857F, 1.593485607070823F, 2.1399481958702475F);
		this.RMustaD = new RendererModel(this, 18, 45);
		this.RMustaD.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.RMustaD.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 8, 0.0F);
		this.setRotateAngle(RMustaD, 0.0F, -0.4553564018453205F, 0.0F);
		this.FingerLAEnd = new RendererModel(this, 32, 2);
		this.FingerLAEnd.setRotationPoint(4.0F, 0.0F, 0.0F);
		this.FingerLAEnd.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
		this.setRotateAngle(FingerLAEnd, 0.0F, 0.0F, 0.8196066167365371F);
		this.BodyB = new RendererModel(this, 0, 0);
		this.BodyB.setRotationPoint(0.0F, 0.0F, 16.0F);
		this.BodyB.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 16, 0.0F);
		this.JawTop = new RendererModel(this, 26, 30);
		this.JawTop.setRotationPoint(-3.5F, 0.0F, -22.0F);
		this.JawTop.addBox(0.0F, 0.0F, 0.0F, 7, 3, 12, 0.0F);
		this.BodyI = new RendererModel(this, 32, 8);
		this.BodyI.setRotationPoint(0.0F, 0.0F, 16.0F);
		this.BodyI.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 16, 0.0F);
		this.LMustaB = new RendererModel(this, 18, 45);
		this.LMustaB.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.LMustaB.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 8, 0.0F);
		this.setRotateAngle(LMustaB, 0.0F, -0.22759093446006054F, 0.0F);
		this.BodyD = new RendererModel(this, 0, 0);
		this.BodyD.setRotationPoint(0.0F, 0.0F, 16.0F);
		this.BodyD.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 16, 0.0F);
		this.HarmL = new RendererModel(this, 32, 51);
		this.HarmL.setRotationPoint(-2.0F, 0.0F, 10.0F);
		this.HarmL.addBox(0.0F, -1.0F, 0.0F, 2, 2, 10, 0.0F);
		this.setRotateAngle(HarmL, 0.0F, 1.2292353921796064F, 0.0F);
		this.BodyKHorne = new RendererModel(this, 36, 21);
		this.BodyKHorne.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.BodyKHorne.addBox(0.0F, 0.0F, 0.0F, 0, 6, 24, 0.0F);
		this.LHorneA = new RendererModel(this, 0, 40);
		this.LHorneA.setRotationPoint(1.0F, -3.0F, -9.0F);
		this.LHorneA.addBox(0.0F, 0.0F, 0.0F, 3, 3, 10, 0.0F);
		this.setRotateAngle(LHorneA, 0.17453292519943295F, 0.3490658503988659F, -0.17453292519943295F);
		this.NoseB = new RendererModel(this, 0, 8);
		this.NoseB.setRotationPoint(-2.0F, 0.0F, -18.5F);
		this.NoseB.addBox(0.0F, 0.0F, 0.0F, 4, 3, 3, 0.0F);
		this.setRotateAngle(NoseB, 0.7853981633974483F, 0.0F, 0.0F);
		this.BodyF = new RendererModel(this, 0, 0);
		this.BodyF.setRotationPoint(0.0F, 0.0F, 16.0F);
		this.BodyF.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 16, 0.0F);
		this.ShoulderL = new RendererModel(this, 86, 44);
		this.ShoulderL.setRotationPoint(4.0F, 0.0F, 8.0F);
		this.ShoulderL.addBox(-2.0F, -1.5F, 0.0F, 4, 3, 10, 0.0F);
		this.setRotateAngle(ShoulderL, 0.0F, 1.4114477660878142F, 1.1838568316277536F);
		this.ThighL = new RendererModel(this, 56, 51);
		this.ThighL.setRotationPoint(4.0F, 0.0F, 8.0F);
		this.ThighL.addBox(-2.5F, -2.0F, -2.5F, 5, 4, 8, 0.0F);
		this.setRotateAngle(ThighL, 0.7740535232594852F, 1.593485607070823F, 2.1399481958702475F);
		this.FingerLB = new RendererModel(this, 32, 0);
		this.FingerLB.setRotationPoint(1.5F, 0.5F, 10.0F);
		this.FingerLB.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
		this.setRotateAngle(FingerLB, -0.7853981633974483F, -2.0943951023931953F, -0.6108652381980153F);
		this.FingerL = new RendererModel(this, 84, 12);
		this.FingerL.setRotationPoint(1.5F, 0.0F, 8.0F);
		this.FingerL.addBox(0.0F, -1.5F, 0.0F, 1, 3, 5, 0.0F);
		this.setRotateAngle(FingerL, 0.0F, -1.4570008595648662F, 0.0F);
		this.BodyA = new RendererModel(this, 0, 0);
		this.BodyA.setRotationPoint(0.0F, 1.0F, 7.0F);
		this.BodyA.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 16, 0.0F);
		this.LMustaA = new RendererModel(this, 18, 45);
		this.LMustaA.setRotationPoint(2.0F, -0.5F, -19.5F);
		this.LMustaA.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 8, 0.0F);
		this.setRotateAngle(LMustaA, 0.0F, 0.0F, 0.3490658503988659F);
		this.FingerRBEnd = new RendererModel(this, 32, 2);
		this.FingerRBEnd.setRotationPoint(4.0F, 0.0F, 0.0F);
		this.FingerRBEnd.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
		this.setRotateAngle(FingerRBEnd, 0.0F, 0.0F, -0.9105382707654417F);
		this.BodyHHorne = new RendererModel(this, 58, -16);
		this.BodyHHorne.setRotationPoint(0.0F, -6.0F, 0.0F);
		this.BodyHHorne.addBox(0.0F, 0.0F, 0.0F, 0, 2, 16, 0.0F);
		this.RHorneB = new RendererModel(this, 104, 3);
		this.RHorneB.setRotationPoint(-4.5F, -5.0F, -1.0F);
		this.RHorneB.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(RHorneB, -1.7453292519943295F, 3.0543261909900767F, 0.0F);
		this.JawBottom = new RendererModel(this, 68, 26);
		this.JawBottom.setRotationPoint(8.0F, 4.0F, 0.0F);
		this.JawBottom.addBox(0.0F, 0.0F, 0.0F, 6, 2, 16, 0.0F);
		this.setRotateAngle(JawBottom, 3.141592653589793F, 0.0F, 3.141592653589793F);
		this.LEye = new RendererModel(this, 0, 0);
		this.LEye.setRotationPoint(2.0F, -3.0F, -11.5F);
		this.LEye.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
		this.setRotateAngle(LEye, 0.0F, -0.5235987755982988F, 0.0F);
		this.HeadBottom = new RendererModel(this, 52, 30);
		this.HeadBottom.setRotationPoint(-5.0F, 1.0F, -5.0F);
		this.HeadBottom.addBox(0.0F, -1.0F, -3.0F, 10, 6, 6, 0.0F);
		this.setRotateAngle(HeadBottom, -0.08726646259971647F, 0.0F, 0.0F);
		this.BodyE = new RendererModel(this, 0, 0);
		this.BodyE.setRotationPoint(0.0F, 0.0F, 16.0F);
		this.BodyE.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 16, 0.0F);
		this.FingerR = new RendererModel(this, 84, 12);
		this.FingerR.setRotationPoint(1.5F, 0.0F, 8.0F);
		this.FingerR.addBox(0.0F, -1.5F, 0.0F, 1, 3, 5, 0.0F);
		this.setRotateAngle(FingerR, 0.0F, -1.4570008595648662F, 0.0F);
		this.BodyIHorne = new RendererModel(this, 58, -16);
		this.BodyIHorne.setRotationPoint(0.0F, -5.0F, 0.0F);
		this.BodyIHorne.addBox(0.0F, 0.0F, 0.0F, 0, 2, 16, 0.0F);
		this.BodyBHorne = new RendererModel(this, 58, -16);
		this.BodyBHorne.setRotationPoint(0.0F, -6.0F, 0.0F);
		this.BodyBHorne.addBox(0.0F, 0.0F, 0.0F, 0, 2, 16, 0.0F);

		this.FingerRA.addChild(this.FingerRAEnd);
		this.BodyG.addChild(this.BodyH);
		this.LMustaC.addChild(this.LMustaD);
		this.HarmR.addChild(this.FingerRB);
		this.ThighL.addChild(this.LegL);
		this.ShoulderR.addChild(this.HarmR);
		this.HeadCenter.addChild(this.RMustaA);
		this.FingerLB.addChild(this.FingerLBEnd);
		this.ThighR.addChild(this.LegR);
		this.HeadBottom.addChild(this.Tongue);
		this.HeadCenter.addChild(this.RHorneA);
		this.HarmR.addChild(this.FingerRA);
		this.LegL.addChild(this.HeelL);
		this.HarmL.addChild(this.FingerLA);
		this.BodyG.addChild(this.BodyGHorne);
		this.HeadCenter.addChild(this.REyebrow);
		this.HarmR.addChild(this.FingerRC);
		this.HeadCenter.addChild(this.LEyebrow);
		this.LegR.addChild(this.HeelR);
		this.BodyC.addChild(this.BodyCHorne);
		this.BodyF.addChild(this.BodyFHorne);
		this.BodyA.addChild(this.BodyAHorne);
		this.BodyI.addChild(this.BodyJ);
		this.HeadCenter.addChild(this.REye);
		this.BodyC.addChild(this.ShoulderR);
		this.BodyJ.addChild(this.BodyJHorne);
		this.RMustaD.addChild(this.RMustaE);
		this.BodyB.addChild(this.BodyC);
		this.HeadCenter.addChild(this.NoseC);
		this.RMustaA.addChild(this.RMustaB);
		this.RMustaB.addChild(this.RMustaC);
		this.BodyE.addChild(this.BodyEHorne);
		this.HeadCenter.addChild(this.NoseD);
		this.HarmL.addChild(this.FingerLC);
		this.BodyD.addChild(this.BodyDHorne);
		this.BodyJ.addChild(this.BodyK);
		this.HeadCenter.addChild(this.LHorneB);
		this.BodyF.addChild(this.BodyG);
		this.HeadCenter.addChild(this.NoseA);
		this.LMustaB.addChild(this.LMustaC);
		this.LMustaD.addChild(this.LMustaE);
		this.BodyH.addChild(this.ThighR);
		this.RMustaC.addChild(this.RMustaD);
		this.FingerLA.addChild(this.FingerLAEnd);
		this.BodyA.addChild(this.BodyB);
		this.HeadCenter.addChild(this.JawTop);
		this.BodyH.addChild(this.BodyI);
		this.LMustaA.addChild(this.LMustaB);
		this.BodyC.addChild(this.BodyD);
		this.ShoulderL.addChild(this.HarmL);
		this.BodyK.addChild(this.BodyKHorne);
		this.HeadCenter.addChild(this.LHorneA);
		this.HeadCenter.addChild(this.NoseB);
		this.BodyE.addChild(this.BodyF);
		this.BodyC.addChild(this.ShoulderL);
		this.BodyH.addChild(this.ThighL);
		this.HarmL.addChild(this.FingerLB);
		this.HeelL.addChild(this.FingerL);
		this.HeadCenter.addChild(this.LMustaA);
		this.FingerRB.addChild(this.FingerRBEnd);
		this.BodyH.addChild(this.BodyHHorne);
		this.HeadCenter.addChild(this.RHorneB);
		this.HeadBottom.addChild(this.JawBottom);
		this.HeadCenter.addChild(this.LEye);
		this.HeadCenter.addChild(this.HeadBottom);
		this.BodyD.addChild(this.BodyE);
		this.HeelR.addChild(this.FingerR);
		this.BodyI.addChild(this.BodyIHorne);
		this.BodyB.addChild(this.BodyBHorne);
	}

	@Override
	public void render(JapaneseDragonEntity dragonEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(dragonEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

		float customScale = dragonEntity.getDragonSize();
		float offset = -0.75F + 1.5F / customScale;
		this.HeadCenter.offsetY += offset;
		this.BodyA.offsetY += offset;

		float rotation = dragonEntity.getHeadTargetAngle();
		this.HeadCenter.rotateAngleX -=rotation;
		this.BodyA.rotateAngleX -= rotation;

		GlStateManager.pushMatrix();
		GlStateManager.scalef(customScale, customScale, customScale);
		this.HeadCenter.render(scale);
		this.BodyA.render(scale);
		GlStateManager.popMatrix();
	}

	@Override
	public void setRotationAngles(JapaneseDragonEntity dragonEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		super.setRotationAngles(dragonEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);

		float PI = (float)Math.PI;
		float moveProgress = dragonEntity.getAnimationLoop(ageInTicks);

		this.HeadCenter.rotateAngleX = headPitch * 0.010F;
		this.HeadCenter.rotateAngleY = netHeadYaw * 0.006F;

		this.HeadCenter.offsetX = 0.25F * sinPI(1 + moveProgress);
		this.HeadCenter.offsetY = 0.15F * sinPI(2.0F * moveProgress);
		this.BodyA.offsetX = 0.25F * sinPI(1 + moveProgress);
		this.BodyA.offsetY = 0.15F * sinPI(2.0F * moveProgress);
		this.BodyA.rotateAngleX = sinPI((moveProgress + 0.25F) * 2) * 0.135F * PI;
		this.BodyA.rotateAngleY = (sinPI(moveProgress + 0.25F) * 0.21F + 0.2F) * PI;
		this.BodyB.rotateAngleX = sinPI((moveProgress - 0.17F) * 2) * 0.35F * PI;
		this.BodyB.rotateAngleY = sinPI(moveProgress - 0.17F) * 0.08F * PI;
		this.LMustaA.rotateAngleY = (sinPI(moveProgress * 2) * 0.05F + 0.2F) * PI;
		this.RMustaA.rotateAngleY = (sinPI(moveProgress * 2) * 0.05F + 0.2F) * PI;
		moveProgress = moveProgress - 0.25F;
		this.LMustaB.rotateAngleY = (sinPI(moveProgress * 2) * 0.1F) * PI;
		this.RMustaB.rotateAngleY = (sinPI(moveProgress * 2) * 0.1F) * PI;
		moveProgress = moveProgress - 0.25F;
		this.BodyC.rotateAngleX = sinPI(moveProgress * 2) * PI * 0.35F;
		this.BodyC.rotateAngleY = sinPI(moveProgress) * PI * 0.2F;
		this.LMustaC.rotateAngleY = (sinPI(moveProgress * 2) * 0.2F) * PI;
		this.RMustaC.rotateAngleY = (sinPI(moveProgress * 2) * 0.2F) * PI;
		moveProgress = moveProgress - 0.25F;
		this.BodyD.rotateAngleX = sinPI(moveProgress * 2) * PI * 0.35F;
		this.BodyD.rotateAngleY = sinPI(moveProgress) * PI * 0.2F;
		this.LMustaD.rotateAngleY = (sinPI(moveProgress * 2) * 0.2F) * PI;
		this.RMustaD.rotateAngleY = (sinPI(moveProgress * 2) * 0.2F) * PI;
		moveProgress = moveProgress - 0.25F;
		this.BodyE.rotateAngleX = sinPI(moveProgress * 2) * PI * 0.35F;
		this.BodyE.rotateAngleY = sinPI(moveProgress) * PI * 0.2F;
		this.LMustaE.rotateAngleY = (sinPI(moveProgress * 2) * 0.2F) * PI;
		this.RMustaE.rotateAngleY = (sinPI(moveProgress * 2) * 0.2F) * PI;
		moveProgress = moveProgress - 0.25F;
		this.BodyF.rotateAngleX = sinPI(moveProgress * 2) * PI * 0.35F;
		this.BodyF.rotateAngleY = sinPI(moveProgress) * PI * 0.2F;
		moveProgress = moveProgress - 0.25F;
		this.BodyG.rotateAngleX = sinPI(moveProgress * 2) * PI * 0.35F;
		this.BodyG.rotateAngleY = sinPI(moveProgress) * PI * 0.2F;
		moveProgress = moveProgress - 0.25F;
		this.BodyH.rotateAngleX = sinPI(moveProgress * 2) * PI * 0.35F;
		this.BodyH.rotateAngleY = sinPI(moveProgress) * PI * 0.2F;
		moveProgress = moveProgress - 0.25F;
		this.BodyI.rotateAngleX = sinPI(moveProgress * 2) * PI * 0.35F;
		this.BodyI.rotateAngleY = sinPI(moveProgress) * PI * 0.2F;
		moveProgress = moveProgress - 0.25F;
		this.BodyJ.rotateAngleX = sinPI(moveProgress * 2) * PI * 0.35F;
		this.BodyJ.rotateAngleY = sinPI(moveProgress) * PI * 0.2F;
		moveProgress = moveProgress - 0.25F;
		this.BodyK.rotateAngleX = sinPI(moveProgress * 2) * PI * 0.35F;
		this.BodyK.rotateAngleY = sinPI(moveProgress) * PI * 0.2F;
	}

	private float sinPI(float f) {
		return MathHelper.sin(f * (float)Math.PI);
	}

	private void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
		RendererModel.rotateAngleX = x;
		RendererModel.rotateAngleY = y;
		RendererModel.rotateAngleZ = z;
	}
}
