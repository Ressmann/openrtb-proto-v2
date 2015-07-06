/*
 * Copyright 2014 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.openrtb.snippet;

import com.google.common.base.MoreObjects;
import com.google.openrtb.OpenRtb.BidRequestOrBuilder;
import com.google.openrtb.OpenRtb.BidResponse;
import com.google.openrtb.OpenRtb.BidResponse.SeatBid.Bid;
import com.google.openrtb.OpenRtb.BidResponse.SeatBid.BidOrBuilder;
import com.google.openrtb.OpenRtb.BidResponseOrBuilder;
import com.google.openrtb.util.ProtoUtils;

/**
 * Context for {@link SnippetProcessor}.
 * <p>
 * This class is threadsafe.
 */
public class SnippetProcessorContext {
  private final BidRequestOrBuilder request;
  private final BidResponse.Builder response;
  private Bid.Builder bid;

  /**
   * @deprecated
   */
  @Deprecated
  public SnippetProcessorContext(BidRequestOrBuilder request, BidResponseOrBuilder response,
      BidOrBuilder bid) {
    this(request, (BidResponse.Builder) ProtoUtils.builder(response));
    this.bid = ProtoUtils.builder(bid);
  }

  public SnippetProcessorContext(BidRequestOrBuilder request, BidResponse.Builder response) {
    this.request = request;
    this.response = response;
  }

  public final BidRequestOrBuilder request() {
    return request;
  }

  public final BidResponse.Builder response() {
    return response;
  }

  public final void setBid(Bid.Builder bid) {
    this.bid = bid;
  }

  public final Bid.Builder getBid() {
    return bid;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).omitNullValues()
        .add("request", request)
        .add("response", ProtoUtils.built(response))
        .add("bid", ProtoUtils.built(bid))
        .toString();
  }
}
