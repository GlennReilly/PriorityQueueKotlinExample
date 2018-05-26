package service

import model.RequestEvent
import java.util.*
import kotlin.math.abs

class RequestQueueManager {
    private val pqInitialCapacity = 10
    val requestEventPriorityQueue: PriorityQueue<RequestEvent> = PriorityQueue(pqInitialCapacity, RequestEvent.PQSort())
}