import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
/**
 * An enum to specify on which side a border should be drawn.
 */
enum class BorderSide { TOP, RIGHT, BOTTOM, LEFT }
/**
 * Draws a border on a single specified side of the Composable.
 *
 * @param side The side of the Composable to draw the border on.
 * @param width The width of the border, specified as a [Dp].
 * @param color The color of the border.
 */
fun Modifier.border(
    side: BorderSide,
    width: Dp = 1.dp,
    color: Color,
): Modifier = this.drawWithContent {
    drawContent()
    val strokeWidth = width.toPx()
    val (start, end) = when (side) {
        BorderSide.TOP ->    Offset(0f, 0f) to Offset(size.width, 0f)
        BorderSide.RIGHT ->  Offset(size.width, 0f) to Offset(size.width, size.height)
        BorderSide.BOTTOM -> Offset(0f, size.height) to Offset(size.width, size.height)
        BorderSide.LEFT ->   Offset(0f, 0f) to Offset(0f, size.height)
    }
    drawLine(
        color = color,
        start = start,
        end = end,
        strokeWidth = strokeWidth,
    )
}