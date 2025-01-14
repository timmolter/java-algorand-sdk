package com.algorand.algosdk.v2.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.algorand.algosdk.util.Encoder;
import com.algorand.algosdk.v2.client.common.PathResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DryrunTxnResult contains any LogicSig or ApplicationCall program debug
 * information and state updates from a dryrun.
 */
public class DryrunTxnResult extends PathResponse {

    @JsonProperty("app-call-messages")
    public List<String> appCallMessages = new ArrayList<String>();

    @JsonProperty("app-call-trace")
    public List<DryrunState> appCallTrace = new ArrayList<DryrunState>();

    /**
     * Execution cost of app call transaction
     */
    @JsonProperty("cost")
    public Long cost;

    /**
     * Disassembled program line by line.
     */
    @JsonProperty("disassembly")
    public List<String> disassembly = new ArrayList<String>();

    /**
     * Application state delta.
     */
    @JsonProperty("global-delta")
    public List<EvalDeltaKeyValue> globalDelta = new ArrayList<EvalDeltaKeyValue>();

    @JsonProperty("local-deltas")
    public List<AccountStateDelta> localDeltas = new ArrayList<AccountStateDelta>();

    @JsonProperty("logic-sig-messages")
    public List<String> logicSigMessages = new ArrayList<String>();

    @JsonProperty("logic-sig-trace")
    public List<DryrunState> logicSigTrace = new ArrayList<DryrunState>();

    @JsonProperty("logs")
    public void logs(List<String> base64Encoded) {
         this.logs = new ArrayList<byte[]>();
         for (String val : base64Encoded) {
             this.logs.add(Encoder.decodeFromBase64(val));
         }
     }
     @JsonProperty("logs")
     public List<String> logs() {
         ArrayList<String> ret = new ArrayList<String>();
         for (byte[] val : this.logs) {
             ret.add(Encoder.encodeToBase64(val));
         }
         return ret; 
     }
    public List<byte[]> logs = new ArrayList<byte[]>();

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;

        DryrunTxnResult other = (DryrunTxnResult) o;
        if (!Objects.deepEquals(this.appCallMessages, other.appCallMessages)) return false;
        if (!Objects.deepEquals(this.appCallTrace, other.appCallTrace)) return false;
        if (!Objects.deepEquals(this.cost, other.cost)) return false;
        if (!Objects.deepEquals(this.disassembly, other.disassembly)) return false;
        if (!Objects.deepEquals(this.globalDelta, other.globalDelta)) return false;
        if (!Objects.deepEquals(this.localDeltas, other.localDeltas)) return false;
        if (!Objects.deepEquals(this.logicSigMessages, other.logicSigMessages)) return false;
        if (!Objects.deepEquals(this.logicSigTrace, other.logicSigTrace)) return false;
        if (!Objects.deepEquals(this.logs, other.logs)) return false;

        return true;
    }
}
